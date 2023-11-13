package org.java;

import java.util.Scanner;

public class Snack5 {

	public static void main(String[] args) {

		// VERSIONE 1: COSTANTI
		final int intA = (int) 'a';
		final int intZ = (int) 'z';
		
		final int int0 = (int) '0';
		final int int9 = (int) '9';
		
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.print("Stringa: ");
			String str = in.nextLine();
			
			if (str.equals("0")) break;
			
			int alpha = 0;
			int numbers = 0;
			int symbol = 0;
			
			// VERSIONE 1: ALGO
			for (int x=0;x<str.length();x++) {
				
				char c = str.toLowerCase().charAt(x);
				int intC = (int) c; // converte il carattere in codice ascii (vedi tabella su internet)
				
				if (intC - intA >= 0 && intZ - intC >= 0) 
					alpha++;
				else if (intC - int0 >= 0 && int9 - intC >= 0) 
					numbers++;
				else symbol++;
			}
			// VERSIONE 2
			for (int x=0;x<str.length();x++) {
				
				char c = str.charAt(x);
				
				if (Character.isAlphabetic(c)) 
					alpha++;
				else if (Character.isDigit(c))
					numbers++;
				else 
					symbol++;
			}
			
			System.out.println("Stats:");
			System.out.println("alpha: " + alpha);
			System.out.println("numbers: " + numbers);
			System.out.println("symbol: " + symbol);
		}
		
		in.close();
		
		System.out.println("\nGood bye!");
	}
}
