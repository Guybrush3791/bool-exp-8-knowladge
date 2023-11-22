package org.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.java.pojo.Evento;

public class ProgrammaEventi {

	private String title;
	private List<Evento> eventi;
	
	public ProgrammaEventi(String title) {
		
		setTitle(title);
		setEventi(new ArrayList<>());
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Evento> getEventi() {
		return eventi;
	}
	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	public void addEvento(Evento evento) {
		
		getEventi().add(evento);
	}
	public List<Evento> getEventiByDate(LocalDate date) {
		
		List<Evento> filteredEvento = new ArrayList<>();
		for (Evento e : getEventi()) 
			if (date.isEqual(e.getDate()))
				filteredEvento.add(e);
		
		return filteredEvento;
	}
	public int getEventiCount() {
		
		return getEventi().size();
	}
	public void clearEventi() {
		
		getEventi().clear();
	}
	
	@Override
	public String toString() {
		
		List<Evento> eventi = getEventi();
		eventi.sort(Comparator.comparing(Evento::getDate));
		
		String acc = "";
		for (Evento e : eventi) 
			acc += e.getHumanDateTime() + " - " + e.getTitle() + "\n";
		
		return getTitle() + "\n" + acc;
	}
}
