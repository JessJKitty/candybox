/***
 * Page for underwater quest
 * 
 * Jessice Xu and Kelwen Peng
 */

package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Underwaterquest extends Activity{

	// initialize battler stats
	Player player;
	ImageView fish;
	ImageView shark;
	int FSH_HP = 15;
	int FSH_ATT = 6;
	int eHp;
	int pHp;
	int FSH_NUM = 10;
	int SHRK_HP = 50;
	

	// initialie field variables
	Button attack;
	Button run;
	Button scroll;
	Button potion;
	TextView playHp;
	TextView enemyHp;
	Toast message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// update view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest_underwaterquest);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// assign fields
		fish = (ImageView) findViewById(R.id.fish);
		shark = (ImageView) findViewById(R.id.shark);
		shark.setVisibility(View.INVISIBLE); 
		playHp = (TextView) findViewById(R.id.playerHp);
		enemyHp = (TextView) findViewById(R.id.enemyHp);
		final Context context = getApplicationContext();
		run = (Button) findViewById(R.id.run);
		potion = (Button) findViewById(R.id.potion);
		scroll = (Button) findViewById(R.id.scroll);
		
		// assign hit points
		eHp = FSH_HP;
		pHp = player.getHp();
		
		// update hit point field
		playHp.setText("Player Hp: " + String.valueOf(pHp));
		enemyHp.setText("Enemy Hp: " + String.valueOf(eHp));
		
		
		// attack button
		attack = (Button) findViewById(R.id.attack);
		
		attack.setOnClickListener(new View.OnClickListener() {
			
			// number of fished killed
			int fshKilled = 0;
			
			@Override
			public void onClick(View v) {
				
				// battle commences
					eHp -= player.Attack();
					pHp -= FSH_ATT;
					
					// if killed a fish
					if (eHp <= 0 && fshKilled <= FSH_NUM){
						
						Toast toast = Toast.makeText(context, "Yay! Only " + String.valueOf(FSH_NUM - fshKilled) + " more fish(ies) !", Toast.LENGTH_SHORT);
						toast.show();
						
						// reset hit points
						eHp = FSH_HP;
						fshKilled++;
						
						
						// transitions to shark
						if (fshKilled >= FSH_NUM){
							
							toast = Toast.makeText(context, "Yay! You beat all the fish! Now for the boss shark!", Toast.LENGTH_SHORT);
							eHp = SHRK_HP;
							fish.setVisibility(View.INVISIBLE); 
							shark.setVisibility(View.VISIBLE); 
							
							}
						}
					
					// if beat shark
					else if(eHp <= 0 && fshKilled > FSH_NUM){
						
						player.setCandies(player.getCandies() + 50000);
						Toast toast = Toast.makeText(context, "Yay! Quest Completed! +  50,000 candies!", Toast.LENGTH_SHORT);
						toast.show();
						Intent resultIntent = new Intent();
						resultIntent.putExtra("data1", player);
						setResult(RESULT_OK, resultIntent);
						finish();
						
					}
					
					// if player loses
					else if (pHp <= 0){
						
						Context context = getApplicationContext();
						Toast toast = Toast.makeText(context, "Aww...You Lost", Toast.LENGTH_SHORT);
						toast.show();
						Intent resultIntent = new Intent();
						resultIntent.putExtra("data1", player);
						setResult(RESULT_OK, resultIntent);
						finish();
						
					}
					
					// update hit points field
					playHp.setText("Player Hp: " + String.valueOf(pHp));
					enemyHp.setText("Enemy Hp: " + String.valueOf(eHp));
			}
		});
		
		run.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent resultIntent = new Intent();
				resultIntent.putExtra("data1", player);
				setResult(RESULT_OK, resultIntent);
				finish();
			}
		});

		
		// upon using "scroll" button
		scroll.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (player.getScrolls() > 0){
					
					eHp -= eHp/2 + 1;
					player.setScrolls(player.getScrolls() - 1);
					enemyHp.setText("Enemy Hp: " + String.valueOf(eHp));
				
				}
				else{
					Toast toast = Toast.makeText(context, "NOOOO! NO TENGO SCROLLS!", Toast.LENGTH_SHORT);
					toast.show();
					
				}
			
				
			}
		});
		
		// upon clicking "potion" button
		potion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (player.getPotions() > 0){
					
					// heals when potion consumed
					if (pHp + player.getHp() > player.getHp()){
						pHp = player.getHp();
						Toast toast = Toast.makeText(context, "Max HP restored!", Toast.LENGTH_SHORT);
						toast.show();
						playHp.setText("Player Hp: " + String.valueOf(pHp));
						player.setPotions(player.getPotions() - 1);

						
					}
					
					else{
						pHp += 100;	
						playHp.setText("Player Hp: " + String.valueOf(pHp));
						player.setPotions(player.getPotions() - 1);

					}	
				
				}
				else{
					Toast toast = Toast.makeText(context, "NOOOO! NO TENGO POTIONS!", Toast.LENGTH_SHORT);
					toast.show();
					
				}
			}
		});
		
		
	}
	

}