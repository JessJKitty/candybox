/***
 * Page before entering forest quest
 * 
 * Jessica Xu and Kelwen Peng
 */
package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forest extends Activity{
	
	private Player player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// displays page content
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest_forest);
		
		// retrieve player
		Bundle bundle = getIntent().getExtras();
		player = (Player)  bundle.get("player");
		
		// initialize page fields
		Button back = (Button) findViewById(R.id.back);
		Button forestquest = (Button) findViewById(R.id.quest);
		
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
		forestquest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// enters forest quest
				Intent i = new Intent("yummy.candies.candybox2.FORESTQUEST");
				i.putExtra("player", player);
				startActivity(i);
			}
		});

	}
}