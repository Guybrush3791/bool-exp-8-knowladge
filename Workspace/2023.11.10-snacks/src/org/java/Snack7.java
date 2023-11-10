package org.java;

import java.util.Scanner;

public class Snack7 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Numero di 4 cifre: ");
		String strValue = in.nextLine();
		
		int sumDigit = 0;
		for (int x=0;x<strValue.length();x++) {
			
			char c = strValue.charAt(x);
			String strC = c + "";
			int digit = Integer.valueOf(strC);
			
			System.out.println("char: " + c);
			System.out.println("str char: " + strC);
			System.out.println("digit: " + digit);
			System.out.println("----------------");
			
			sumDigit += digit;
		}
		
		System.out.println("Somma delle cifre: " + sumDigit);
	}
}
