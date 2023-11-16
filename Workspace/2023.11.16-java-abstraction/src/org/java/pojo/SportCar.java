package org.java.pojo;

import org.java.pojo.abs.Car;

public class SportCar extends Car {

	public static final int DOORS_COUNT = 2;
	
	public SportCar(String name, int maxSpeed) {
		
		super(name, maxSpeed);
	}
	
	@Override
	public void printDoorsCount() {
		
		System.out.println("Numero porte: " + DOORS_COUNT);
	}

	
	public void turnOnTurbo() {
		
		System.out.println("Ho attivato il turbo!!!");
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " - numero porte: " + DOORS_COUNT;
	}
}
