package org.java;

import java.util.Random;

public class Snack3 {

	public static void main(String[] args) {
		
		final int VALUES_COUNT = 10;
		Random rnd = new Random();
		
		int[] values = new int[VALUES_COUNT];
		for (int x=0;x<VALUES_COUNT;x++) {
			
			int rndValue = rnd.nextInt(1,11);
			values[x] = rndValue;
			
			System.out.println("random value: " + rndValue);
		}
		
		System.out.println("-------------------------------");
		
		int sum = 0;
		for (int x=1;x<VALUES_COUNT;x+=2) {
			
			int value = values[x];
			sum += value;
		}
		
		System.out.println("sum: " + sum);
	}
}
