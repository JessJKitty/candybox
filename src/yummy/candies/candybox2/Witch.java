/***
 * Page to see the witch and get some spells
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

public class Witch extends Activity{
	
	// initialize player
	Player player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// update view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory_witch);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		//initialize views
		Button back = (Button) findViewById(R.id.back);
		Button witchmore = (Button) findViewById(R.id.witchmore);
		Button witchsword = (Button) findViewById(R.id.witchsword);
		Button witchfaster = (Button) findViewById(R.id.witchfaster);
		
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
		
		// upon clicking "more candies"
		witchmore.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {	
				
				if (player.getLollipops() < 40000){
					
					Toast.makeText(getApplicationContext(), "HEY, You ain't got enough lollies to pay up, bro.", Toast.LENGTH_SHORT).show();		
				}
				else{
					
					player.setCandies(player.getEatenCandies()*500 + player.getCandies());
					Toast.makeText(getApplicationContext(), "Yay, more candies!", Toast.LENGTH_SHORT).show();		
					player.setLollipops(player.getLollipops() - 40000);
				}
			}
		});
		
		// upon clicking better sword
		witchsword.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				if (player.getLollipops() < 90000){
					
					Toast.makeText(getApplicationContext(), "HEY, You ain't got enough lollies to pay up, bro.", Toast.LENGTH_SHORT).show();		
				}
				else{
					
					player.setSword((int) (player.getSword()*1.5));
					Toast.makeText(getApplicationContext(), "Yay, better sword!", Toast.LENGTH_SHORT).show();		
					player.setLollipops(player.getLollipops() - 90000);
				}			
			}
		});
		
		// upon clicking faster candy
		witchfaster.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				if (player.getLollipops() < 50000){
					Toast.makeText(getApplicationContext(), "HEY, You ain't got enough lollies to pay up, bro.", Toast.LENGTH_SHORT).show();		
				}
				else{
					player.setCandiesPerSecond(player.getCandiesPerSecond() + 1);
					Toast.makeText(getApplicationContext(), "Yay, faster candies!", Toast.LENGTH_SHORT).show();		
					player.setLollipops(player.getLollipops() - 50000);
				}	
			}
		});
	}
}