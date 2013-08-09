package com.example.hellofeed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class PlanetDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_planet_detail);
		
		Intent intent = getIntent();
		String planet_id = intent.getStringExtra(MainActivity.PLANETDETAIL_ID);
		
		TextView tv = new TextView(this);
		tv.setTextSize(40);
		tv.setText(planet_id);
		
		setContentView(tv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.planet_detail, menu);
		return true;
	}

}
