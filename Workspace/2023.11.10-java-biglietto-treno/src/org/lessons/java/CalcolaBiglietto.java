package org.lessons.java;

import java.util.Scanner;

public class CalcolaBiglietto {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Km da percorrere: ");
		String strKm = in.nextLine();
		int km = Integer.valueOf(strKm);
		
		System.out.print("Eta': ");
		String strAge = in.nextLine();
		int age = Integer.valueOf(strAge);
		
		in.close();
		
		double price = km * .21;
		
		if (age < 18) {
			
			price = price / 100 * 80;
		}
		if (age > 65) { 
			
			price = price / 100 * 60;
		}
		System.out.println("Prezzo finale: " + String.format("%.2f", price) + "€");
	}
}
