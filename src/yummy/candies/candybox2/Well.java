/***
 * Page for the wishing well
 * 
 * Jessica Xu and Kelwen Peng
 */

package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Well extends Activity{
	
	Player player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// update view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_well);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// initialize fields
		Button back = (Button) findViewById(R.id.back);
		Button wellcandies = (Button) findViewById(R.id.wellcandies);
		Button welllollipops = (Button) findViewById(R.id.welllollipops);
		Button wellworldpeace = (Button) findViewById(R.id.wellworldpeace);
		
		// upon clicking "back" button
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				Intent resultIntent = new Intent();
				resultIntent.putExtra("data1", player);
				setResult(RESULT_OK, resultIntent);
				finish();
			}
		});
		
		// upon clicking 5x candies
		wellcandies.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				if (player.getWishes() < 5){
					
					player.setCandies(player.getCandies()*5);
					Toast.makeText(getApplicationContext(), "yay! Candies x 5!", Toast.LENGTH_SHORT).show();		
					player.setWishes(player.getWishes() + 1);
				}
				else {
					
					Toast.makeText(getApplicationContext(), "you've been too greedy. Candies / 5!", Toast.LENGTH_SHORT).show();		
					player.setCandies(player.getCandies()/5);
					player.setWishes(player.getWishes() + 1);
					
				}
			}
		});
		
		// upon clicking more lollipops
		welllollipops.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				if (player.getWishes() < 5){
					
					player.setLollipops(player.getLollipops()*8);
					Toast.makeText(getApplicationContext(), "yay! Lollies * 8!", Toast.LENGTH_SHORT).show();		
					player.setWishes(player.getWishes() + 1);
				}
				else {
					
					Toast.makeText(getApplicationContext(), "you've been too greedy. Lollies / 8!", Toast.LENGTH_SHORT).show();		
					player.setLollipops(player.getLollipops()/8);
					player.setWishes(player.getWishes() + 1);
					
				}		
			}
		});
		
		// upon clicking world peace
		wellworldpeace.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				Toast.makeText(getApplicationContext(), "Well, aren't you a goody-two-shoes... Still, wishing wells don't exist!", Toast.LENGTH_SHORT).show();		
			}
		});
	}
}