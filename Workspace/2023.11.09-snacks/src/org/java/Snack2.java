package org.java;

import java.util.Scanner;

public class Snack2 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Parola 1: ");
		String word1 = in.nextLine();
		int lng1 = word1.length();
		
		System.out.print("Parola 2: ");
		String word2 = in.nextLine();
		int lng2 = word2.length();
		
		in.close();
		
		if (lng1 == lng2) {
			
			System.out.println("Le due parole hanno la stessa lunghezza:\n"
								+ "- " + word1 + "\n"
								+ "- " + word2);
		} else if (lng1 > lng2) {
			
			System.out.println("La prola piu' lunga e' '" + word1 + "'");
		} else {
			
			System.out.println("La prola piu' lunga e' '" + word2 + "'");
		}
	}
}
