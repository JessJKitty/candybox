package yummy.candies.candybox2;

import yummy.candies.candybox2.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Merchant extends Activity {
	
	private TextView merchtalk; 
	
	private TextView candies;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.merchant);
		
		candies = (TextView) findViewById(R.id.candies);
		merchtalk.setText("Candies" + String.valueOf(player.getCandies()));
				
		merchtalk = (TextView) findViewById(R.id.merchtalk); 
		
		//upon clicking the button
		Button merchbuylollies = (Button) findViewById(R.id.lollipop);
		merchbuylollies.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				buy("lollipop", merchtalk);
			}
		});
		
		//upon clicking the button
		Button merchbuysword = (Button) findViewById(R.id.sword);
		merchbuysword.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				player.buy("sword", merchtalk);
			}
		});
		
		//upon clicking the button
		Button merchbuyscroll = (Button) findViewById(R.id.scroll);
		merchbuyscroll.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				buy("scroll", merchtalk);
			}
		});
		
		//upon clicking the button
		Button merchbuypotion = (Button) findViewById(R.id.potion);
		merchbuypotion.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				buy("potion", merchtalk);
			}
		});
				
	}
	public void buy(String object, TextView merchtalk){
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
		else if (object.equals("scroll")){
			if (player.getCandies() > 400){
				player.setCandies(player.getCandies() - 400);
				player.setScrolls(player.getScrolls() + 1);
				merchtalk.setText("You bought a scroll! It gives EVERYONE on the map 10 damage. kthxbai");
			}
			else{
				merchtalk.setText("You ain't got 'nuff munny, bro.");
			}
		}
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
	
