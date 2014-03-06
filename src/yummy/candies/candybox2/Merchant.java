/***
 * Merchant page allows players to buy an assortment 
 * of items such as a sword or lollipops
 * 
 * Jessica Xu and Kelwen Peng
 */
package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Merchant extends Activity {
	
	// Merchant class-specific instantiation
	private TextView merchtalk; 
	private Player player;
	private TextView candies;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// update view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.merchant);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// set all the crap to actual crap
		candies = (TextView) findViewById(R.id.candies);	
		merchtalk = (TextView) findViewById(R.id.merchtalk); 
		Button merchbuylollies = (Button) findViewById(R.id.lollipop);
		Button merchbuysword = (Button) findViewById(R.id.sword);
		Button merchbuyscroll = (Button) findViewById(R.id.scroll);
		Button merchbuypotion = (Button) findViewById(R.id.potion);
		Button back = (Button) findViewById(R.id.back);
		
		// tells players how many candies they have
		candies.setText("Candies: " + String.valueOf(player.getCandies()));
		
		// upon clicking the button
		merchbuylollies.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				buy("lollipop", merchtalk);
				candies.setText("Candies: " + String.valueOf(player.getCandies()));
			}
		});
		
		//upon clicking the button
		merchbuysword.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				buy("sword", merchtalk);
				candies.setText("Candies: " + String.valueOf(player.getCandies()));
			}
		});
		
		//upon clicking the button
		merchbuyscroll.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				buy("scroll", merchtalk);
				candies.setText("Candies: " + String.valueOf(player.getCandies()));
			}
		});
		
		//upon clicking the button
		merchbuypotion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				buy("potion", merchtalk);
				candies.setText("Candies: " + String.valueOf(player.getCandies()));
			}
		});
		
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
		
	}
	
	// buy function
	public void buy(String object, TextView merchtalk){
		
		// for sword
		if (object.equals("sword")){
			if (player.getCandies() > (player.getSword()*500 + 300)){
				player.setCandies(player.getCandies() - player.getSword()*500 + 300);
				player.setSword(player.getSword() + 1);
				merchtalk.setText("You bought a sword! kthxbai!");
			}
			else{
				merchtalk.setText("You ain't got 'nuff munny, bro.");
			}
		}
		
		// for scroll
		else if (object.equals("scroll")){
			if (player.getCandies() > 400){
				player.setCandies(player.getCandies() - 400);
				player.setScrolls(player.getScrolls() + 1);
				merchtalk.setText("You bought a scroll! It nearly halves your opponent's damage taken.! You still have to attack to kill it, though. kthxbai");
			}
			else{
				merchtalk.setText("You ain't got 'nuff munny, bro.");
			}
		}
		
		// for potion
		else if (object.equals("potion")){
			if (player.getCandies() > 200){
				player.setCandies(player.getCandies() - 200);
				player.setPotions(player.getPotions() + 1);
				merchtalk.setText("You bought a potion! It heals 100 hp! kthxbai!");
			}
			else{
				merchtalk.setText("You ain't got 'nuff munny, bro.");
			}

		}
		
		// for lollipops
		else{
			if (player.getCandies() > 60){
				player.setCandies(player.getCandies() - 60);
				player.setLollipops(player.getLollipops() + 1);
				merchtalk.setText("You bought a lollipop! kthxbai");
			}
			else{
				merchtalk.setText("You ain't got 'nuff munny, bro.");
			}
		}
		
	}
	
}
	
