package com.example.hellofeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	List<Map<String, String>> planetsList = new ArrayList<Map<String, String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initList();
		
		ListView lv = (ListView) findViewById(R.id.listView);
		
		SimpleAdapter aAdpt = new SimpleAdapter(MainActivity.this, planetsList, R.layout.planet_feed, new String[] {"planet"}, new int[] {R.id.label});
		
		lv.setAdapter(aAdpt);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
				//We may not always clicked on the TextView since we are using customized layout	
				//TextView clickedView = (TextView) view;
				
				Toast.makeText(MainActivity.this, "Item with id[" + id + "] - Position [" + position + "]",  Toast.LENGTH_LONG).show();

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
			planetsList.add(createPlanet("planet", "Mercury"));
			planetsList.add(createPlanet("planet", "Venus"));
			planetsList.add(createPlanet("planet", "Mars"));
			planetsList.add(createPlanet("planet", "Jupiter"));
			planetsList.add(createPlanet("planet", "Saturn"));
			planetsList.add(createPlanet("planet", "Uranus"));
			planetsList.add(createPlanet("planet", "Neptune"));
	}
	
	private HashMap<String, String> createPlanet(String key, String name) {
		HashMap<String, String> planet = new HashMap<String, String>();
		planet.put(key,  name);
		
		return planet;
	}
	

}
