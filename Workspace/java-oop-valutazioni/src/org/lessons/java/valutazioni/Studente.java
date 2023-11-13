package org.lessons.java.valutazioni;

public class Studente {

	private int id;
	private int percAssenze;
	private float mediaVoti;
	
	public Studente(int id, int percAssenze, float mediaVoti) {
		
		setId(id);
		setPercAssenze(percAssenze);
		setMediaVoti(mediaVoti);
	}
	
	public int getId() {
		
		return id;
	}
	private void setId(int id) {
		
		this.id = id;
	}
	public int getPercAssenze() {
		
		return percAssenze;
	}
	public void setPercAssenze(int percAssenze) {
		
		this.percAssenze = percAssenze;
	}
	public float getMediaVoti() {
		
		return mediaVoti;
	}
	public void setMediaVoti(float mediaVoti) {
		
		this.mediaVoti = mediaVoti;
	}
	
	public boolean isPromoted() {
		
		if (getPercAssenze() > 50) return false;
		if (getPercAssenze() > 25 && getPercAssenze() < 50 && getMediaVoti() <= 2)
			return false;
		
		return getMediaVoti() >= 2;
	}
	
	@Override
	public String toString() {
		
		return "Studente:\n"
				+ "id: " + getId() + "\n"
				+ "perc assenze: " + getPercAssenze() + "%\n"
				+ "media voti: " + String.format("%.01f", getMediaVoti()) + "/5\n"
				+ "------------------------------------------\n"
				+ "promosso: " + (isPromoted() ? "si'" : "no");
	}
}
