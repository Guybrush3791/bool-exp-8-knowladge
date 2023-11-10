package org.java;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Snack4 {

	public static void main(String[] args) {
		
		String[] nomi = {
			"Mario", "Luigi", "Giovanna", "Anna", "Carlo", 
			"Maria", "Luca", "Giuseppe", "Elena", "Francesca"
		};
		
		Scanner in = new Scanner(System.in);
		System.out.print("Dimmi il tuo nome:");
		String name = in.nextLine();
		
		for (int x=0;x<nomi.length;x++) {
			
			String gName = nomi[x];
			
			if (gName.equals(name)) {
				
				System.out.println("Puoi entrare");
				return;
//				break;
			}
		}
		System.out.println("Non puoi entrare");
	}
}
