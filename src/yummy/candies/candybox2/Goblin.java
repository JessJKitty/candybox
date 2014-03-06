/***
 * Page before entering Goblin quest
 * 
 * Jessica Xu and Kelwen Peng
 */
package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Goblin extends Activity{
	
	// initialize Player
	private Player player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// set view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest_goblin);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// initialize fields
		Button back = (Button) findViewById(R.id.back);
		Button goblinquest = (Button) findViewById(R.id.goblinquest);
		
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
		
		// upon clicking "quest" button
		goblinquest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// generates new Intent and enters quest
				Intent i = new Intent("yummy.candies.candybox2.GOBLINQUEST");
				i.putExtra("player", player);
				startActivity(i);
				
			}
		});

	}
}