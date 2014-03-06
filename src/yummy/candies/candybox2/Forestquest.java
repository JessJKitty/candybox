/***
 * Battle page for forest quest
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

public class Forestquest extends Activity{

	// initialize battler stats
	Player player;
	int TRE_Hp = 15;
	int eHp;
	int pHp;
	int TRE_NUM = 10;
	
	// initialize field variables
	ImageView tree;
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
		setContentView(R.layout.quest_forestquest);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// assign hit points
		eHp = TRE_Hp;
		pHp = player.getHp();
		
		// assign hit point fields
		playHp = (TextView) findViewById(R.id.playerHp);
		enemyHp = (TextView) findViewById(R.id.enemyHp);
		
		// updates hit point fields 
		playHp.setText("Player Hp: " + String.valueOf(pHp));
		enemyHp.setText("Enemy Hp: " + String.valueOf(eHp));
		
		// other fields
		final Context context = getApplicationContext();
		attack = (Button) findViewById(R.id.attack);
		run = (Button) findViewById(R.id.run);
		potion = (Button) findViewById(R.id.potion);
		scroll = (Button) findViewById(R.id.scroll);
		
		
		// upon hitting "attack"
		attack.setOnClickListener(new View.OnClickListener() {
			
			// how many enemies there are
			int treLeft = 10;
			
			@Override
			public void onClick(View v) {
				
				// updates hitpoints
					eHp -= player.Attack();
					
					// if player wins and killed 10 trees
					if (eHp <= 0 && treLeft > 1){
						
						// updates
						treLeft--;
						Toast toast = Toast.makeText(context, "Yay! Only " + String.valueOf(treLeft) + " more trees !", Toast.LENGTH_SHORT);
						toast.show();
						
						// reset enemy's hit points
						eHp = TRE_Hp;
						}
					
					// if beats all enemies
					else if(eHp <= 0 && treLeft <= 1){
						player.setCandies(player.getCandies() + 500);
						Toast toast = Toast.makeText(context, "Yay! Quest Completed! + 500 candies!", Toast.LENGTH_SHORT);
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
					
					// update hit points
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
						player.setPotions(player.getPotions() - 1);
					}
					
					else{
						pHp += 100;	
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