/***
 * Page before entering the Underwater quest
 * 
 * Jessica Xu and Kelwen Peng
 */

package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Underwater extends Activity{
	
	// initialize player 
	private Player player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// update view
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest_underwater);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// initialize field variables
		Button back = (Button) findViewById(R.id.back);
		Button underwaterquest = (Button) findViewById(R.id.underwaterquest);
		
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
		underwaterquest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// enters into UnterwaterQuest
				Intent i = new Intent("yummy.candies.candybox2.UNDERWATERQUEST");
				i.putExtra("player", player);
				startActivity(i);
			}
		});

	}
}