package org.java;

import java.util.Scanner;

public class Snack5 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Quanti cubi vuoi? ");
		String strNCubi = in.nextLine();
		int nCubi = Integer.valueOf(strNCubi);
		
		for (int x=1;x<=nCubi;x++) {
			
			System.out.println(x + " --> " + (x * x));
		}
	}
}
