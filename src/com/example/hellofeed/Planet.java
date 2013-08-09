package com.example.hellofeed;

public class Planet {
	
	private String name;
	private String descr;
	private int idImg;
	
	public Planet(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIdImg() {
		return idImg;
	}
	
	public void setIdImg(int idImg) {
		this.idImg = idImg;
	}
}
