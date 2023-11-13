package org.java;

import java.util.Arrays;
import java.util.Random;

public class Snack2 {

	public static void main(String[] args) {
		
		final int GUEST_COUNT = 10;
		
		Random rnd = new Random(100);
		
		String[] nomi = {"Mario", "Luigi", "Giovanna", "Anna", "Carlo", "Maria", "Luca", "Giuseppe", "Elena", "Francesca"};
		String[] cognomi = {"Rossi", "Bianchi", "Verdi", "Russo", "Ferrari", "Esposito", "Romano", "Gallo", "Conti", "Marino"};
		
		String[] guests = new String[GUEST_COUNT];
		
		for (int x=0;x<GUEST_COUNT;x++) {
			
			String rndNome = nomi[rnd.nextInt(nomi.length)];
			String rndCongnome = cognomi[rnd.nextInt(cognomi.length)];
			
			String rndFullName = rndNome + " " + rndCongnome;
			guests[x] = rndFullName;
		}
		
		System.out.println(Arrays.asList(guests));
	}
}
