package yummy.candies.candybox2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inventory extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inventory);
		
		//frogbutton
		Button invfrog = (Button) findViewById(R.id.frog);
		invfrog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				finish();
			}
		});
		
		//witch button
		Button invwitch = (Button) findViewById(R.id.witch);
		invwitch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				finish();
			}
		});
		
		
		//well button. 
		Button invwell = (Button) findViewById(R.id.well);
		invwell.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				//filler material
				finish();
			}
		});

	}
	
}