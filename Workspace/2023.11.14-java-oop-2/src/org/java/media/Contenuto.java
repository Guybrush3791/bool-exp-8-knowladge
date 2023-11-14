package org.java.media;

import java.util.Arrays;

public class Contenuto {

	public static final int MY_VALUE = 10;
	
	protected String title;
	private String[] actors;
	
	public Contenuto(String title, String[] actors) {
		
		setTitle(title);
		setActors(actors);
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getActors() {
		return actors;
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	
	public void riproduci() {
		
		System.out.println("Riproduci contenuto " + getTitle());
	}
	
	@Override
	public String toString() {
		
		return "title: " + getTitle() + "\n"
				+ "actors: " + Arrays.asList(getActors());
	}
}
