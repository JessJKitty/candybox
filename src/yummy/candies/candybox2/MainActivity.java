package yummy.candies.candybox2;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.Runnable;

public class MainActivity extends Activity {

	// initialize 
	
	public Player player = new Player();
	


	
	private TextView textfield;
	private Handler handler;
	private boolean running = true;
	
	private TextView TVeatencandies;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textfield = (TextView) findViewById(R.id.TVTimer);
		handler = new Handler();
		Runnable runnable = new Runnable(){

		@Override
		public void run(){
			while(running = true){
				try{
					Thread.sleep(1000);
					}
				catch (InterruptedException e) {
					e.printStackTrace();
					}
				handler.post(new Runnable(){
					@Override
					public void run(){
						player.setCandies(player.getCandies() + 1);
						textfield.setText("Candies:" + String.valueOf(player.getCandies()));
						}
					});
				}
			}
		};
		new Thread(runnable).start();
		
		// Inventory
		Button inv = (Button) findViewById(R.id.inventory);
		inv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("yummy.candies.candybox2.INVENTORY");
				startActivity(i);
			}
		});
		
		// redirects player to merchant  page
		Button merch1 = (Button) findViewById(R.id.merchant);
		merch1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("yummy.candies.candybox2.MERCHANT");
				startActivity(i);
			}
		});
		
		// redirects player to quest  page
		Button quest = (Button) findViewById(R.id.quest);
		quest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent("yummy.candies.candybox2.QUEST");
				startActivity(i);
			}
		});
		// redirects player to quest  page
		Button eat = (Button) findViewById(R.id.eat);
		eat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				player.setEatenCandies(player.getEatenCandies() + player.getCandies());
				TVeatencandies = (TextView) findViewById(R.id.TVeatencandies);
				TVeatencandies.setText("Eaten Candies:" + String.valueOf(player.getEatenCandies()));
				player.setCandies(0); 
				textfield.setText("Candies:" + String.valueOf(player.getCandies()));
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
