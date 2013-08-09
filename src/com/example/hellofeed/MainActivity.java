package com.example.hellofeed;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String PLANETDETAIL_ID = "com.example.hellofeed.PLANETDETAIL_ID";
	public List<Planet> planetsList = new ArrayList<Planet>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initList();
		
		ListView lv = (ListView) findViewById(R.id.listView);
		
		//SimpleAdapter aAdpt = new SimpleAdapter(MainActivity.this, planetsList, R.layout.planet_feed, new String[] {"planet"}, new int[] {R.id.label});
		PlanetAdapter aAdpt = new PlanetAdapter(planetsList, this);
		
		lv.setAdapter(aAdpt);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
				
				Intent intent = new Intent(MainActivity.this, PlanetDetailActivity.class);
				intent.putExtra(PLANETDETAIL_ID, planetsList.get(position).getName());
				startActivity(intent);
				
			}
		});
		
		registerForContextMenu(lv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		
		super.onCreateContextMenu(menu,  v,  menuInfo);
		
		menu.setHeaderTitle("Options for this planet");
		menu.add(1, 1, 1, "Details");
		menu.add(1, 2, 2, "Delete");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		Toast.makeText(this, "Item id [" + itemId + "]", Toast.LENGTH_LONG).show();
		return true;
	}
	
	
	private void initList() {
			planetsList.add(new Planet("Mercury", 10));
			planetsList.add(new Planet("Venus", 20));
			planetsList.add(new Planet("Mars", 30));
			planetsList.add(new Planet("Jupiter", 40));
			planetsList.add(new Planet("Saturn", 50));
			planetsList.add(new Planet("Uranus", 60));
			planetsList.add(new Planet("Neptune", 70));
	}

	

}
