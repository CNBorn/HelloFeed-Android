package com.example.hellofeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
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
		
		SimpleAdapter s = new SimpleAdapter(this, planetsList, android.R.layout.simple_list_item_1, new String[] {"planet"}, new int[] {android.R.id.text1});
		
		lv.setAdapter(s);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
				TextView clickedView = (TextView) view;
				
				Toast.makeText(MainActivity.this, "Item with id[" + id + "] - Position [" + position + "] - Planet [" + clickedView.getText() + "]",  Toast.LENGTH_LONG).show();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
