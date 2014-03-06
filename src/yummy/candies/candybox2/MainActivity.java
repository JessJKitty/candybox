/***********************
 * Main file for Candy Box! Allows users to save files 
 * and to go to other places like the merchant or take
 * on quests
 * 
 * Jessica Xu and Kelwen Peng
 */

package yummy.candies.candybox2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Runnable;

public class MainActivity extends Activity {
	
	// initialize player
	private Player player;
	
	// initialize variables for file management
	public Parcel savedParcel;
	private FileInputStream fis;
	private FileOutputStream fos;
	byte[] savedFile;
	final String FILE_NAME = "candy_player";
	
	// initialize variables specific to MainActivity
	private TextView textfield;
	private Handler handler;
	private TextView TVeatencandies;
	private TextView lollipops;
	private TextView plantedlollipops;
	private final int COM = 0;
	
	// executes code before creating the Activity
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// sets up screen
		setContentView(R.layout.activity_main);
		
		// set up lollipop display 
		lollipops = (TextView) findViewById(R.id.lollipops);
		plantedlollipops = (TextView) findViewById(R.id.plantedlollipops);
		
		// set up counter
		textfield = (TextView) findViewById(R.id.TVTimer);
		handler = new Handler();
		
		// open file
		File file = new File(FILE_NAME);
		
		// if file existed already
		if (!file.exists()){
			player = new Player();
		}
		
		// if file didn't exist
		else{
			
			//creates file
			try {
				
				fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
				fos.close();

			} catch (FileNotFoundException e1) {
				
				// if FILE_NAME is empty				
				e1.printStackTrace();
				
			} catch (IOException e) {
				
				// if file can't be closed
				e.printStackTrace();
			}
			
			try {
				
				// opens file and saves into saveFile as as a byte array
				fis = this.openFileInput(FILE_NAME);
				
			} catch (FileNotFoundException e1) {
				
				// if opened file is missing
				e1.printStackTrace();
				

			}finally {
				try {
					
					// close read file
					fis.close();
					
					// converts file to Player object
					player = new Player(ParcelableUtil.unmarshall(savedFile));
					
				} catch (IOException e) {
					
					// if file is missing
					e.printStackTrace();
					
				}
			}
		}

		// create runnable file to increase candies and lollipops every second
		Runnable runnable = new Runnable(){
			
			// override method
			@Override
			public void run(){
				
				// continuous running
				while(true){
					
					try{
						
						// wait 1 second
						Thread.sleep(1000);
						
						}
					
					// if Thread is interrupted
					catch (InterruptedException e) {
						
						// if Thread is interrupted
						e.printStackTrace();
						
						}
					
					// changes candies and lollipops  in Player object and updates respective textFields
					handler.post(new Runnable(){
						@Override
						public void run(){
							
							player.setCandies(player.getCandies() + player.getCandiesPerSecond());
							player.setLollipops(player.getLollipops() + player.getPlantedLollipops());
							lollipops.setText("Lollipops: " + String.valueOf(player.getLollipops()));
							textfield.setText("Candies: " + String.valueOf(player.getCandies()));
							
							}
						
						});
					}
				};
		};
		
		// execute described Thread
		new Thread(runnable).start();
		
		// Inventory button
		Button inv = (Button) findViewById(R.id.inventory);
		inv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// create new Intent and imports Player data
				Intent i = new Intent("yummy.candies.candybox2.INVENTORY");
				i.putExtra("player", player);
				startActivityForResult(i, COM);
				
			}
		});
		
		// redirects player to merchant  page
		Button merch1 = (Button) findViewById(R.id.merchant);
		merch1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// create new Intent and imports Player data
				Intent i = new Intent(getApplicationContext(), Merchant.class);
				i.putExtra("player", player);
				startActivityForResult(i, COM);
				
			}
		});
		
		// redirects player to quest page
		Button quest = (Button) findViewById(R.id.quest);
		quest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// create new Intent and imports Player data
				Intent i = new Intent("yummy.candies.candybox2.QUEST");
				i.putExtra("player", player);
				startActivityForResult(i, COM);
				
			}
		});
		
		// eat candies
		Button eat = (Button) findViewById(R.id.eat);
		eat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// sets number of candies to 0 and updates eaten candies and respective textFields
				player.setEatenCandies(player.getEatenCandies() + player.getCandies());
				TVeatencandies = (TextView) findViewById(R.id.TVeatencandies);
				TVeatencandies.setText("Eaten Candies:" + String.valueOf(player.getEatenCandies()));
				player.setCandies(0); 
				textfield.setText("Candies:" + String.valueOf(player.getCandies()));
				
			}
		});
		
		
		//the troll button you can press to increase your candies. 
		Button troll = (Button) findViewById(R.id.troll);
		troll.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// increase Player's candies by 10
				player.setCandies(player.getCandies() + 10);
				textfield.setText("Candies:" + String.valueOf(player.getCandies()));
				
			} 
			
		});
		
		//Lollifarm
		Button lollifarm = (Button) findViewById(R.id.lollifarm);
		lollifarm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// plants lollipops
				if (player.getLollipops() > 0 && player.getPlantedLollipops() < 100){
					
					player.setLollipops(player.getLollipops() - 1);
					player.setPlantedLollipops(player.getPlantedLollipops() + 1);
					lollipops.setText("Lollipops: " + String.valueOf(player.getLollipops()));
					
				}
				
				// if rate of getting lollipops is over 100
				else if(player.getPlantedLollipops() >= 100){
					
					player.setLollipops(player.getLollipops() - 1);
					Toast.makeText(getApplicationContext(), "Don't get greedy. 100 lollipops per second is good enough for you =P", Toast.LENGTH_SHORT).show();
				
				}
				
				// otherwise, player has no lollipops
				else{
					
					Toast.makeText(getApplicationContext(), "No moar lollies =(", Toast.LENGTH_SHORT).show();
					
				}
				
				// updates text
				plantedlollipops.setText("Planted Lollipops: " + String.valueOf(player.getPlantedLollipops()));
				
			} 
		}); 
		
		// saves player's information
		Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {
					
					// open file-to-be-saved
					fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
					
				} catch (FileNotFoundException e) {
					
					// if cannot be opened/created
					e.printStackTrace();
					
				}
				
				// parcels and saves in savedFile
				savedFile = ParcelableUtil.marshall(player); 
				
				try {
					
					// writes savedFile into FILE_NAME
					fos.write(savedFile, 0, savedFile.length);
					
					// success!
					Context context = getApplicationContext();
					Toast toast = Toast.makeText(context, "Save Complete!", Toast.LENGTH_SHORT);
					toast.show();
					
					// close file
					fos.close();
					
				} catch (IOException e) {
					
					// writing into fos has problems
					e.printStackTrace();
					
				}
			}
		});
		
		// loads saved file
		Button load = (Button) findViewById(R.id.load);
		load.setOnClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
				
				try {
					
					// opens file and saves into saveFile as as a byte array
					fis = openFileInput(FILE_NAME);
					
				} catch (FileNotFoundException e1) {
					
					// if cannot open
					e1.printStackTrace();
					
				}finally {
					try {
						
						fis.close();
						player = new Player(ParcelableUtil.unmarshall(savedFile));
						
						Context context = getApplicationContext();
						Toast toast = Toast.makeText(context, "Load Complete!", Toast.LENGTH_SHORT);
						toast.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	// detects when called Activities are done
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == COM){
			if(resultCode == RESULT_OK){
				
				// updates player
				player = data.getParcelableExtra("data1");
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present - useless to us 
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
