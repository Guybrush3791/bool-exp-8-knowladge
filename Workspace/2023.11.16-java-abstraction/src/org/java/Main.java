package org.java;

import org.java.pojo.SportCar;
import org.java.pojo.UtilityCar;
import org.java.pojo.abs.Car;

public class Main {

	public static void main(String[] args) {
		
		SportCar sc = new SportCar("Ferrari", 300);
		System.out.println(sc);
		
		UtilityCar uc = new UtilityCar("Fiesta", 160);
		System.out.println(uc);
		
		Car[] cars = new Car[2];
		
		cars[0] = sc;
		cars[1] = uc;
		
		for (int x=0;x<cars.length;x++) {
			
			Car c = cars[x];
			c.printDoorsCount();
			
//			c.turnOnTurbo();
		}
	}
}
