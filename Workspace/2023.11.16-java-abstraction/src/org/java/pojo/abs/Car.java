package org.java.pojo.abs;

public abstract class Car {
	
	private String name;
	private int maxSpeed;
	
	public Car(String name, int maxSpeed) {
	
		setName(name);
		setMaxSpeed(maxSpeed);
	}
	
	public abstract void printDoorsCount();
	
	public void printName() {
		
		System.out.println(getName());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public void printMaxSpeed() {
		
		System.out.println("Velocita' massima: " + getMaxSpeed() + "km/h");
	}
	public void turnOn() {
		
		System.out.println("Brum!");
	}
	public void breakMe() {
		
		System.out.println("Rallenta");
	}
	
	@Override
	public String toString() {
		
		return getName() + " - " + getMaxSpeed() + "km/h";
	}
}
