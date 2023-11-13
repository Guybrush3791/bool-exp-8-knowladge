package org.java;

import java.util.Scanner;

public class Snack4 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Parola: ");
		String word = in.nextLine();
		
		// VERSIONE 1
		boolean palindrom = true;
		for (int x=0;x<word.length()/2;x++) {
			
			char cWord = word.charAt(x);
			char revCWord = word.charAt(word.length() - x - 1);
			
			if (cWord != revCWord) {
				
				palindrom = false;
				break;
			}
		}
		
		if (palindrom) {
			System.out.println("Parola palindroma: " + word);
		} else {
			
			System.out.println("Parola non palindroma: " + word);
		}
		
		// VERSIONE 2
		String revString = "";
		for (int x=word.length() - 1;x>=0;x--) {
			
			revString += word.charAt(x);
		}
		
		if (word.equals(revString)) {
			
			System.out.println("Parola palindroma: " + word);
		} else {
			
			System.out.println("Parola non palindroma: " + word);
		}
	}
}
