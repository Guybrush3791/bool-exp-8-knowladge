package org.java;

import java.util.Scanner;

public class Snack1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Numero: ");
		String strValue = in.nextLine();
		int value = Integer.valueOf(strValue);
		
		in.close();
		
//		// VERSIONE 1
//		if (value % 2 == 0) {
//			
//			System.out.println("Value: " + value);
//		} else {
//			
//			System.out.println("Next value: " + (value + 1));
//		}
		
		// VERSIONE 2
		System.out.println(
			value % 2 == 0 
		    ? "Value: " + value
		    : "Next value: " + (value + 1)
		);
	}
}
