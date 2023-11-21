package org.lessons.java.charscounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Parola: ");
		
		String word = in.nextLine();
		
		in.close();
		
		Map<Character, Integer> frequency = new HashMap<>();
		for (Character c : word.toCharArray()) {
			
			if (!frequency.containsKey(c))
				frequency.put(c, 1);
			else 
				frequency.put(c, frequency.get(c) + 1);
		}
		
		System.out.println(frequency);
	}
}
