/***
 * The Inventory page displays the swords as well as 
 * some other secrets like visiting the frog or the witch 
 * 
 * Jessica Xu and Kelwen Peng
 */

package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inventory extends Activity{
	
	// initialize player and files
	private int COM = 3;
	Player player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// update view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// initialize field variables
		Button back = (Button) findViewById(R.id.back);
		Button invfrog = (Button) findViewById(R.id.frog);
		Button invwitch = (Button) findViewById(R.id.witch);
		Button invwell = (Button) findViewById(R.id.well);
		
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
		
		// upon clicking "frog" button
		invfrog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				Intent i = new Intent("yummy.candies.candybox2.FROG");
				i.putExtra("player", player);
				startActivityForResult(i, COM);
			}
		});
		
		// upon clicking "witch" button
		invwitch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				Intent i = new Intent("yummy.candies.candybox2.WITCH");
				i.putExtra("player", player);
				startActivityForResult(i, COM);
			}
		});
		
		// upon clicking "well" button
		invwell.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				Intent i = new Intent("yummy.candies.candybox2.WELL");
				i.putExtra("player", player);
				startActivityForResult(i, COM);
			}
		});

	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == COM){
			if(resultCode == RESULT_OK){
				
				// receive data and convert to Player Object to have the latest update on information
				player = data.getParcelableExtra("data1");
			}
		}
	}
	
}