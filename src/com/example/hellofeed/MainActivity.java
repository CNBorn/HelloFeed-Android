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
	public static List<Planet> planetsList = new ArrayList<Planet>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initList();
		
		ListView lv = (ListView) findViewById(R.id.listView);
		
		PlanetAdapter aAdpt = new PlanetAdapter(planetsList, this);
		
		lv.setAdapter(aAdpt);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
				
				Intent intent = new Intent(MainActivity.this, PlanetDetailActivity.class);
				intent.putExtra(PLANETDETAIL_ID, Integer.toString(position));
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
			planetsList.add(new Planet("Mercury"));
			planetsList.add(new Planet("Venus"));
			planetsList.add(new Planet("Earth"));
			planetsList.add(new Planet("Mars"));
			planetsList.add(new Planet("Jupiter"));
			planetsList.add(new Planet("Saturn"));
			planetsList.add(new Planet("Uranus"));
			planetsList.add(new Planet("Neptune"));
	}

	

}
