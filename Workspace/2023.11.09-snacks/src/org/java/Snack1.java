package org.java;

import java.util.Scanner;

public class Snack1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Eta' persona 1: ");
		String strAge1 = in.nextLine();
		int intAge1 = Integer.valueOf(strAge1);
		
		System.out.print("Eta' persona 2: ");
		String strAge2 = in.nextLine();
		int intAge2 = Integer.valueOf(strAge2);
		
		if (intAge1 > intAge2) {
			
			System.out.println("La prima persona e' piu' grande");
		} else if (intAge2 > intAge1) {
			
			System.out.println("La seconda persona e' piu' grande");
		} else {
			
			System.out.println("La due persone hanno la stessa eta'");
		}
	}
}
