package org.java;

import java.util.Scanner;

public class Snack1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Valore 1: ");
		String strValue1 = in.nextLine();
		int value1 = Integer.valueOf(strValue1);
		
		System.out.print("Valore 2: ");
		String strValue2 = in.nextLine();
		int value2 = Integer.valueOf(strValue2);
		
		in.close();
		
		if (value1 > value2) {
			
			System.out.println("Il maggiore e' " + value1);
		} else if (value2 > value1) {
			
			System.out.println("Il maggiore e' " + value2);
		} else {
			
			System.out.println("I valori sono uguali: " + value1);
		}
	}
}
