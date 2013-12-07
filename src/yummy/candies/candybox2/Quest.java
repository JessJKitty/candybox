package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quest);

		
		//upon clicking the button
		Button questforest = (Button) findViewById(R.id.forest);
		questforest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				finish();
			}
		});
		
		//upon clicking the button
		Button goblin = (Button) findViewById(R.id.goblin);
		goblin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				finish();
			}
		});
		
		//upon clicking the button
		Button underwater = (Button) findViewById(R.id.underwater);
		underwater.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				finish();
			}
		});
				
				
	}

}