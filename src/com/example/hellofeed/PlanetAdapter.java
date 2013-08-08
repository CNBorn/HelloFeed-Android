package com.example.hellofeed;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PlanetAdapter extends ArrayAdapter<Planet> {
	
	private List<Planet> planetList;
	private Context context;

	public PlanetAdapter(List<Planet> planetList, Context ctx) {
		super(ctx, R.layout.planet_feed, planetList);
		this.planetList = planetList;
		this.context = ctx;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		PlanetHolder holder = new PlanetHolder();
		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.planet_feed, null);
			TextView tv = (TextView) v.findViewById(R.id.label);
			
			holder.planetNameView = tv;
			
			v.setTag(holder);
		}
		else
			holder = (PlanetHolder) v.getTag();
		
		Planet p = planetList.get(position);
		holder.planetNameView.setText(p.getName());
		
		return v;
	}
	
	private static class PlanetHolder {
		public TextView planetNameView;
		public TextView distView;
	}	
	
}
