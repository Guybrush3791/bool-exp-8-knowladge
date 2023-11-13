package org.java;

import java.util.Scanner;

public class Snack7 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Secondi: ");
		String strSeconds = in.nextLine();
		int mySeconds = Integer.valueOf(strSeconds);
		
		in.close();
		
		int hours = mySeconds / 3600;
		int hoursRest = mySeconds % 3600;
		
		int minutes = hoursRest / 60;
		int seconds = mySeconds % 60;
		
		System.out.println(
			  String.format("%02d", hours) + ":" 
			+ String.format("%02d", minutes) + ":" 
			+ String.format("%02d", seconds)
		);
	}
}
