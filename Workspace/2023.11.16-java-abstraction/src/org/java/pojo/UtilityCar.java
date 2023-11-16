package org.java.pojo;

import org.java.pojo.abs.Car;

public class UtilityCar extends Car {

	public static final int DOORS_COUNT = 5;
	
	public UtilityCar(String name, int maxSpeed) {
		
		super(name, maxSpeed);
	}

	@Override
	public void printDoorsCount() {

		System.out.println("Numero porte: " + DOORS_COUNT);
	}
	
	public void trainaAuto() {
		
		System.out.println("Sto trainando un'auto...");
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " - numero porte: " + DOORS_COUNT;
	}
}
