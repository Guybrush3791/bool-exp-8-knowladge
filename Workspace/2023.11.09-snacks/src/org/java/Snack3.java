package org.java;

import java.util.Random;

public class Snack3 {

	public static void main(String[] args) {
		
		final int VALUE_COUNT = 10;
		
		Random rnd = new Random(100);
		
		// Genera array con 10 elementi casuali compresi tra 0 e 100
		int[] values = new int[VALUE_COUNT];
		for (int x=0;x<values.length;x++) {
			
			values[x] = rnd.nextInt(0, 101);
			System.out.println("values[" + x + "]: " + values[x]);
		}
		
		// Trova il valore massimo
		int max = Integer.MIN_VALUE;
		for (int x=0;x<values.length;x++) {
			
			int value = values[x];
			if (value > max) {
				
				max = value;
			}
		}
		
		// Trova il valore minimo
		int min = Integer.MAX_VALUE;
		for (int x=0;x<values.length;x++) {
			
			int value = values[x];
			if (value < min) {
				
				min = value;
			}
		}
		
		// Trova il valore medio
		int avg = 0;
		for (int x=0;x<values.length;x++) {
			
			int value = values[x];
			avg += value;
		}
		avg /= values.length;
		
		// Stampa risultati
		System.out.println("max: " + max);
		System.out.println("min: " + min);
		System.out.println("avg: " + avg);
	}
}
