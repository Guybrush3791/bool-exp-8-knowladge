package org.java;

import java.util.Scanner;

public class Snack3 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int sum = 0;
		for (int x=0;x<10;x++) {
			
			System.out.print("Inserisci valore " + (x + 1) + ": ");
			String strValue = in.nextLine();
			int value = Integer.valueOf(strValue);
			
			sum += value;
		}
		
		System.out.println("Somma: " + sum);
	}
}
