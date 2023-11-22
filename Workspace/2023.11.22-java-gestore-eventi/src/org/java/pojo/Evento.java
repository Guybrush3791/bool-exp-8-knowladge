package org.java.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.java.helper.Helper;

public class Evento {

	private String title;
	private LocalDate date;
	private int seatCapacity;
	private int seatReserved;
	
	public Evento(String title, LocalDate date, int seatCapacity) throws Exception {
		
		setTitle(title);
		setDate(date);
		setSeatCapacity(seatCapacity);
		setSeatReserved(0);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) throws Exception {
		
		LocalDate today = LocalDate.now();
		if (today.isAfter(date))
			throw new Exception("Event date can't be in the past");
		
		this.date = date;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	private void setSeatCapacity(int seatCapacity) throws Exception {
		
		if (seatCapacity <= 0) 
			throw new Exception("Seat capacity can't be lower then 1");
		
		this.seatCapacity = seatCapacity;
	}
	public int getSeatReserved() {
		return seatReserved;
	}
	private void setSeatReserved(int seatReserved) {
		this.seatReserved = seatReserved;
	}
	
	public void prenota() throws Exception {
		
		prenota(1);
	}
	public void prenota(int quantity) throws Exception {
		
		if (isInPast())
			throw new Exception("Event is already gone");
		
		if (seatReserved + quantity > seatCapacity)
			throw new Exception("No more available seat");
		
		seatReserved += quantity;
	}
	
	public void disdici() throws Exception {
		
		disdici(1);
	}
	public void disdici(int quantity) throws Exception {
		
		if (isInPast())
			throw new Exception("Event is already gone");
		
		if (seatReserved - quantity < 0)
			throw new Exception("No more available seat");
		
		seatReserved -= quantity;
	}

	public String getSeatStr() {
		
		return getSeatReserved() + "/" + getSeatCapacity();
	}
	
	public String getHumanDateTime() {
		
		return getDate().format(Helper.IT_DATE_FORMATTER);
	}
	
	@Override
	public String toString() {
		
		return getHumanDateTime() + " - " + getTitle();
	}
	
	private boolean isInPast() {
		
		LocalDate today = LocalDate.now();
		return today.isAfter(getDate());
	}
}
