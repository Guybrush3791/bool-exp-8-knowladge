package org.java.train;

public class Ticket {
	
	private static final float PRICE_PER_KM = .21f;
	
	private static final int MINOR_AGE_LIMIT = 18;
	private static final int MAJOR_AGE_LIMIT = 65;
	
	private static final int MINOR_DISCOUNT = 80;
	private static final int MAJOR_DISCOUNT = 60;
	
	private int km;
	private int age;
	
	public Ticket(int km, int age) throws Exception {
		
		setKm(km);
		setAge(age);
	}
	
	public int getKm() {
		return km;
	}
	public void setKm(int km) throws Exception {
		
		if (km <= 0)
			throw new Exception("Km can't be negative");
		
		this.km = km;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception {
		
		if (age <= 0)
			throw new Exception("Age can't be negative");
		
		this.age = age;
	}
	
	public float getFinalPrice() {
		
		float price = km * PRICE_PER_KM;
		
		if (age < MINOR_AGE_LIMIT) {
			
			price = price / 100 * MINOR_DISCOUNT;
		}
		if (age > MAJOR_AGE_LIMIT) { 
			
			price = price / 100 * MAJOR_DISCOUNT;
		}
	
		return price;
	}
}
