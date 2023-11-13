package org.java;

import java.util.Scanner;

public class Snack10 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Valore 1: ");
		String strValue1 = in.nextLine();
		int value1 = Integer.valueOf(strValue1);
		
		System.out.print("Valore 2: ");
		String strValue2 = in.nextLine();
		int value2 = Integer.valueOf(strValue2);
		
		int sum = 0;
		for (int x=value1;x<=value2;x++) {
			
			sum += x;
		}
		
		System.out.println("Sommatoria da " + value1 + " a " + value2 + ": " + sum);
	}
}
