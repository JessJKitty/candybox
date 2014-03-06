/***
 * Quest page for Goblin Forest
 * 
 * Jessica Xu and Kelwen Peng
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

public class Goblinquest extends Activity{

	// initialize player stats
	Player player;
	ImageView goblin;
	int GOB_HP = 15;
	int GOB_ATT = 5;
	int eHp;
	int pHp;
	int GOB_NUM = 5;
	int GTB_HP = 30;
	
	// initialize field variables
	Button attack;
	Button run;
	Button scroll;
	Button potion;
	TextView playHp;
	TextView enemyHp;
	Toast message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// generate view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest_goblinquest);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// sets picture
		goblin = (ImageView) findViewById(R.id.goblin);
		
		// assign hit points
		eHp = GOB_HP;
		pHp = player.getHp();
		
		// assign field hit points
		playHp = (TextView) findViewById(R.id.playerHp);
		enemyHp = (TextView) findViewById(R.id.enemyHp);
		
		// updates field hit points
		playHp.setText("Player Hp: " + String.valueOf(pHp));
		enemyHp.setText("Enemy Hp: " + String.valueOf(eHp));
		
		// initialize other fields
		final Context context = getApplicationContext();
		attack = (Button) findViewById(R.id.attack);
		run = (Button) findViewById(R.id.run);
		potion = (Button) findViewById(R.id.potion);
		scroll = (Button) findViewById(R.id.scroll);
		
		// upon "attack" button pressed
		attack.setOnClickListener(new View.OnClickListener() {
			
			// number of goblins killed
			int gobKilled = 0;
			
			@Override
			public void onClick(View v) {
					
					//update hit points
					eHp -= player.Attack();
					pHp -= GOB_ATT;
					
					// if won battle, but not all battles
					if (eHp <= 0 && gobKilled <= GOB_NUM){
						Toast toast = Toast.makeText(context, "Yay! Only " + String.valueOf(GOB_NUM - gobKilled) + " more goblin(s) !", Toast.LENGTH_SHORT);
						toast.show();
						
						// update hitpoints
						eHp = GOB_HP;
						gobKilled++;
						
						// if beat all goblins, attack boss
						if (gobKilled >= GOB_NUM){
							
							toast = Toast.makeText(context, "Yay! You beat all the goblins! Now for the REAL goblin.", Toast.LENGTH_SHORT);
							eHp = GTB_HP;
							
							}
						}
					
					// if all battles won
					else if(eHp <= 0 && gobKilled > GOB_NUM){
						
						player.setCandies(player.getCandies() + 5000);
						
						Toast toast = Toast.makeText(context, "Yay! Quest Completed! 5000 candies for you!", Toast.LENGTH_SHORT);
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
						finish();
					}
					
					// update hit point fields
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