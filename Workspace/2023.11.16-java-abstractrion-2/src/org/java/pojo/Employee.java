package org.java.pojo;

import java.time.LocalDate;

import org.java.pojo.abs.Worker;

public class Employee extends Worker {

	private int monthlyWage;
	private int monthlyNumber;
	
	public Employee(String name, String lastname, LocalDate dateOfBirth,
			int monthlyWage, int monthlyNumber) {
		
		super(name, lastname, dateOfBirth);
		
		setMonthlyWage(monthlyWage);
		setMonthlyNumber(monthlyNumber);
	}

	public int getMonthlyWage() {
		return monthlyWage;
	}
	public void setMonthlyWage(int monthlyWage) {
		this.monthlyWage = monthlyWage;
	}
	public int getMonthlyNumber() {
		return monthlyNumber;
	}
	public void setMonthlyNumber(int monthlyNumber) {
		this.monthlyNumber = monthlyNumber;
	}

	@Override
	public int getYearSalary() {
		
		return getMonthlyWage() * getMonthlyNumber();
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
				+ "year salary: " + getYearSalary();
	}
}
