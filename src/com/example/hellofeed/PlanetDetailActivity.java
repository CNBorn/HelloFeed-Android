package com.example.hellofeed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_planet_detail);
		
		Intent intent = getIntent();
		int planet_id = Integer.parseInt(intent.getStringExtra(MainActivity.PLANETDETAIL_ID));
		
		Planet planet = MainActivity.planetsList.get(planet_id);
		
		TextView planet_name = (TextView) findViewById(R.id.planet_name);
		planet_name.setText(planet.getName());

		TextView planet_detail = (TextView) findViewById(R.id.planet_detail);
		int detail_id = getResources().getIdentifier("@string/planet_detail_" + planet.getName().toLowerCase(), "id", getPackageName());
		planet_detail.setText(getString(detail_id));
				
		ImageView planet_img = (ImageView) findViewById(R.id.planet_image);
		int id = getResources().getIdentifier("@drawable/" + planet.getName().toLowerCase(), "id", getPackageName());
		planet_img.setImageResource(id);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.planet_detail, menu);
		return true;
	}

}
