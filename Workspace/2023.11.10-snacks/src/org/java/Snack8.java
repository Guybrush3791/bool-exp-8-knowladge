package org.java;

public class Snack8 {

	public static void main(String[] args) {
		
		final int VALUE_COUNT = 10;
		
		int sum = 0;
		for (int x=1;x<=VALUE_COUNT;x++) {
			
			sum += x;
		}
		
		int avg = sum / VALUE_COUNT;
		
		System.out.println("Sommatoria: " + sum);
		System.out.println("Media: " + avg);
	}
}
