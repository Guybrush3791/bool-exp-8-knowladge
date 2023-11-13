package org.java;

import java.util.Arrays;
import java.util.Random;

public class Snack11 {

	public static void main(String[] args) {
		
		final int VALUES_COUNT = 10;
		
		Random rnd = new Random(100);
		Integer[] values = new Integer[VALUES_COUNT];
		
		for (int x=0;x<VALUES_COUNT;x++) {
			
			int rndValue = rnd.nextInt(11);
			values[x] = rndValue;
		}
		
		System.out.println("Valori: " + Arrays.asList(values));
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		float avg = 0;
		
		for (int x=0;x<VALUES_COUNT;x++) {
			
			int value = values[x];
			
			if (max < value) 
				max = value;
			
			if (min > value) 
				min = value;
			
			avg += value;
		}
		
		avg /= VALUES_COUNT;
		
		System.out.println("Stats:");
		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
		System.out.println("Avg: " + String.format("%.02f", avg));
	}
	
	void test() { 
		
		return; // eq al break nei loop ma per i metodi
	}
	
	String test2(boolean value) {
		
		if (value) 
			return "hello";
		
		return null;
	}
}
