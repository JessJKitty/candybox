/***
 * Final boss quest - players face not the Mona Lisa but
 * themselves. Is there a way to beat it? Meh...not right
 * now.
 * 
 * Jessica Xu and Kelwen Peng
 * 
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

public class Finalbossquest extends Activity{

	// initialize battler stats
	Player player;
	int eHp;
	int pHp;
	int TRE_NUM = 10;
	
	// initialize fields on the screen
	Button attack;
	Button run;
	Button scroll;
	Button potion;
	TextView playHp;
	TextView enemyHp;
	Toast message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest_finalbossquest);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// set hit points
		eHp = player.getHp();
		pHp = player.getHp();
		
		// assign field variables
		playHp = (TextView) findViewById(R.id.playerHp);
		enemyHp = (TextView) findViewById(R.id.enemyHp);
		attack = (Button) findViewById(R.id.attack);
		run = (Button) findViewById(R.id.run);
		potion = (Button) findViewById(R.id.potion);
		scroll = (Button) findViewById(R.id.scroll);
		
		// display hit points
		playHp.setText("Player Hp: " + String.valueOf(pHp));
		enemyHp.setText("Enemy Hp: " + String.valueOf(eHp));
		
		// show message
		final Context context = getApplicationContext();
		message = Toast.makeText(context,  "NO! IT'S NOT THE MONA LISA! IT'S YOURSELF!", Toast.LENGTH_LONG);
		message.show();
		
		// if attack button is pressed
		attack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// hit points changed accordingly
					eHp -= player.Attack();
					pHp -= player.Attack();
					if (pHp <= 0){
						
						// losing message
						Context context = getApplicationContext();
						Toast toast = Toast.makeText(context, "Aww...You Lost", Toast.LENGTH_SHORT);
						toast.show();
						Intent resultIntent = new Intent();
						resultIntent.putExtra("data1", player);
						setResult(RESULT_OK, resultIntent);
						finish();
						
					}
					else if (pHp > 0 && eHp < 0){
						
						// winning message
						player.setCandies(player.getCandies() + 500000000);
						Toast toast = Toast.makeText(context, "You have now surpassed yourself, young grasshopper take 500000000 candies!", Toast.LENGTH_SHORT);
						toast.show();
						Intent resultIntent = new Intent();
						resultIntent.putExtra("data1", player);
						setResult(RESULT_OK, resultIntent);
						finish();
					}
					
					// update Hp
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
					pHp -= pHp/2 + 1;
					player.setScrolls(player.getScrolls() - 1);
					
					playHp.setText("Player Hp: " + String.valueOf(pHp));
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
						eHp = player.getHp();
						Toast toast = Toast.makeText(context, "Max HP restored!", Toast.LENGTH_SHORT);
						toast.show();
						playHp.setText("Player Hp: " + String.valueOf(pHp));
						enemyHp.setText("Enemy Hp: " + String.valueOf(eHp));
						player.setPotions(player.getPotions() - 1);
					}
					
					else{
						pHp += 100;	
						eHp += 100;
						playHp.setText("Player Hp: " + String.valueOf(pHp));
						enemyHp.setText("Enemy Hp: " + String.valueOf(eHp));
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