package org.java.media;

public class Film extends Contenuto {

	// private String title;
	private long durata;
	
	public Film(String title, String[] actors, long durata) {
		
		super(title, actors);
		
		setDurata(durata);
	}

	public long getDurata() {
		return durata;
	}
	public void setDurata(long durata) {
		this.durata = durata;
	}
	
	public void sayHello() {
		
		System.out.println("Hello, World!");
	}
	
	@Override
	public void riproduci() {
		
		System.out.println("Riproduco film: " + title);
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
			+ "durata: " + getDurata();
	}
}
