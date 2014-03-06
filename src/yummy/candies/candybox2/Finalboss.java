/*********
 * Page before entering the final boss quest
 * 
 * Jessica Xu and Kelwen Peng
 */
package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Finalboss extends Activity{
	
	private Player player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// create Activity for final boss
		super.onCreate(savedInstanceState);
		
		// updates view for player
		setContentView(R.layout.quest_finalboss);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// initialize buttons
		Button back = (Button) findViewById(R.id.back);
		Button finalbossquest = (Button) findViewById(R.id.finalboss);
		
		// upon clicking "back" button
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				// send information back to preceding page and destroys Activity
				Intent resultIntent = new Intent();
				resultIntent.putExtra("data1", player);
				setResult(RESULT_OK, resultIntent);
				finish();
			}
		});
		
		// upon clicking "quest" button
		finalbossquest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// create new Intent and enter final boss quest 
				Intent i = new Intent("yummy.candies.candybox2.FINALBOSSQUEST");
				i.putExtra("player", player);
				startActivity(i);
			}
		});


	}
}