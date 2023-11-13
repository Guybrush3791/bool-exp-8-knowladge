package org.lessons.java;

import java.util.Random;

import org.lessons.java.valutazioni.Studente;

public class Main {

	public static void main(String[] args) {
		
		final int STUDENTI_COUNT = 20; 
		
		Random rnd = new Random();		
		for (int x=0;x<STUDENTI_COUNT;x++) {
			
			Studente s = new Studente(x + 1, rnd.nextInt(101), rnd.nextFloat(0, 5));			
			System.out.println(s + "\n------------------------------------------\n");
		}
	}
}
