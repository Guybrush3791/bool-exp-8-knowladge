package org.java.pojo;

import java.time.LocalDate;

import org.java.pojo.abs.Worker;

public class Boss extends Worker {

	private int monthlyRevenue;
	private int yearBonus;
	
	public Boss(String name, String lastname, LocalDate dateOfBirth,
			int monthlyRevenue, int yearBonus) {
		
		super(name, lastname, dateOfBirth);
		
		setMonthlyRevenue(monthlyRevenue);
		setYearBonus(yearBonus);
	}
	
	public int getMonthlyRevenue() {
		return monthlyRevenue;
	}
	public void setMonthlyRevenue(int monthlyRevenue) {
		this.monthlyRevenue = monthlyRevenue;
	}
	public int getYearBonus() {
		return yearBonus;
	}
	public void setYearBonus(int yearBonus) {
		this.yearBonus = yearBonus;
	}
	
	@Override
	public int getYearSalary() {
		
		return getMonthlyRevenue() * 12 + getYearBonus();
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
			  + "year salary: " + getYearSalary();
	}
}
