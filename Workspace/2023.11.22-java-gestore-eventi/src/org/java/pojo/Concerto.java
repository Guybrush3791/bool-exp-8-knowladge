package org.java.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.java.helper.Helper;

public class Concerto extends Evento {

	private LocalTime time;
	private BigDecimal price;
	
	public Concerto(String title, LocalDate date, int seatCapacity, 
			LocalTime time, BigDecimal price) throws Exception {

		super(title, date, seatCapacity);

		setTime(time);
		setPrice(price);
	}

	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
	public String getHumanPrice() {
		
		return Helper.PRICE_FORMATTER.format(getPrice());
	}
	
	@Override
	public String getHumanDateTime() {
		
		return super.getHumanDateTime() + " " + getTime().format(Helper.IT_TIME_FORMATTER);
	}
	@Override
	public String toString() {
		
		return super.toString() + " - " + getHumanPrice();
	}
}
