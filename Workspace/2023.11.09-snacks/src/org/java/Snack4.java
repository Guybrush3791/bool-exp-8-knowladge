package org.java;

import java.util.Random;

public class Snack4 {

	public static void main(String[] args) {
		
		String[] giorniSettimana = {"Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom"};
		
		System.out.println("For:");
		for(int i = 0; i < giorniSettimana.length; i++) {
			
			String day = giorniSettimana[i];
			System.out.print(day + " ");
		}
		
		System.out.println("\n------------------------------------\n");
		System.out.println("While:");
		
		int x = 0;
		while(x < giorniSettimana.length) {
			
			String day = giorniSettimana[x];
			System.out.print(day + " ");
			
			x++;
		}
		
		System.out.println("\n------------------------------------\n");
		System.out.println("\n------------------------------------\n");
		System.out.println("While:");
		
		Random rnd = new Random();
		int sum = 0;
		while (sum < 100) {
			
			int value = rnd.nextInt(0, 11);
			System.out.println("value: " + value);
			
			sum += value;
		}
		
		System.out.println("final sum: " + sum);
		
		System.out.println("\n------------------------------------\n");
		System.out.println("For:");
		
		sum = 0;
		for (;sum<100;) {
			
			int value = rnd.nextInt(0, 11);
			System.out.println("value: " + value);
			
			sum += value;
		}
		
		System.out.println("final sum: " + sum);
	}
}














