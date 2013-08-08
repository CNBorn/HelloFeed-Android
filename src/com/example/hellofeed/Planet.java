package com.example.hellofeed;

public class Planet {
	
	private String name;
	private Integer distance;
	private String descr;
	private int idImg;
	
	public Planet(String name, Integer distance) {
		this.name = name;
		this.distance = distance;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getDistance() {
		return distance;
		
	}
	
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	public int getIdImg() {
		return idImg;
	}
	
	public void setIdImg(int idImg) {
		this.idImg = idImg;
	}
}
