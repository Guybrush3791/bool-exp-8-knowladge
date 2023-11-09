package org.java;

import java.util.Random;
import java.util.Scanner;

public class Snack5 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Random rnd = new Random();
		
		int[] values = new int[5];
		for (int x=0;x<values.length;x++) {
			
			int rndValue = rnd.nextInt(0, 11);
			values[x] = rndValue;
			
			System.out.println("value: " + rndValue);
		}
		
		System.out.print("Dammi il tuo numero fortunato:");
		String strValue = in.nextLine();
		int intValue = Integer.valueOf(strValue);
		
		boolean finded = false;
		for (int x=0;x<values.length;x++) {
			
			int value = values[x];
			
			if (value == intValue) {
				
				finded = true;
				break;
			}
		}
		
		System.out.println(
				finded 
				? "HAI VINTO"
				: "HAI PERSO"
		);
		
//		// APPROFONDIMENTO: break & continue
//		for (int x=0;x<10;x++) {
//			
//			if (x == 5) break;
//			if (x % 2 == 0) // x contiene un valore pari
//				continue;
//			
//			System.out.println(x);
//		}
//		System.out.println("the end");
		 
	}
}
