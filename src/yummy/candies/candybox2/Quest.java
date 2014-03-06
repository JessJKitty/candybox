/***
 * Quest page that displays all the available quests for 
 * players to enter and attempt to beat
 * 
 * Jessica Xu and Kelwen Peng
 */

package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quest extends Activity {
	
	// initialize player/file variables
	private int COM = 2;
	private Player player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// update view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest);
		
		// retrieves player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// initilize field variables
		Button back = (Button) findViewById(R.id.back);
		Button questforest = (Button) findViewById(R.id.forest);
		Button goblin = (Button) findViewById(R.id.goblin);
		Button underwater = (Button) findViewById(R.id.underwater);
		Button finalboss = (Button) findViewById(R.id.finalboss);
		
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
		
		//upon clicking forest button
		questforest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				Intent i = new Intent("yummy.candies.candybox2.FOREST");
				i.putExtra("player", player);
				startActivityForResult(i, COM);
			}
		});
		
		//upon clicking goblin button
		goblin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				Intent i = new Intent("yummy.candies.candybox2.GOBLIN");
				i.putExtra("player", player);
				startActivityForResult(i, COM); 
			}
		});
		
		//upon clicking underwater button
		underwater.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				Intent i = new Intent("yummy.candies.candybox2.UNDERWATER");
				i.putExtra("player", player);
				startActivityForResult(i, COM);
			}
		});
		
		//upon clicking final boss button
		finalboss.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				Intent i = new Intent("yummy.candies.candybox2.FINALBOSS");
				i.putExtra("player", player);
				startActivityForResult(i, COM);
			}
		});
				
				
	}
	
	// retried data from recently closed activities, if any
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if(requestCode == COM){
			if(resultCode == RESULT_OK){
				player = data.getParcelableExtra("data1");
			}
		}
	}

}