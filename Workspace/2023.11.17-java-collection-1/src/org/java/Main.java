package org.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		List<Integer> values = new ArrayList<>();
		
		values.add(rnd.nextInt(10));
		values.add(rnd.nextInt(10));
		values.add(rnd.nextInt(10));
		values.add(rnd.nextInt(10));
		values.add(rnd.nextInt(10));
		values.add(rnd.nextInt(10));
		values.add(rnd.nextInt(10));
		values.add(rnd.nextInt(10));
		values.add(rnd.nextInt(10));
		values.add(rnd.nextInt(10));
		
		System.out.println(values);
		System.out.println("\n-----------------------\n");

		for (int value : values) {
			
			System.out.println("value: " + value);
		}
		
		System.out.println("\n-----------------------\n");
		
		for (int x=0;x<values.size();x++) {
			
			int value = values.get(x);
			System.out.println("value " + (x+1) +": " + value);
		}
		
		System.out.println("\n-----------------------\n");
		
		Iterator<Integer> it = values.iterator();
		while (it.hasNext()) {
			
			Integer value = it.next();
			System.out.println("value: " + value);
		}
		
		System.out.println("\n-----------------------\n");
		
		int index = 1;
		Integer value = 8;
		
		values.remove(index); // 1
		values.remove(value); // (Integer) 8
		
		// ------------------------------------------------
		
		Set<Integer> uniqueValues = new HashSet<>();
		
		uniqueValues.add(1);
		uniqueValues.add(2);
		uniqueValues.add(3);
		uniqueValues.add(4);
		uniqueValues.add(5);
		uniqueValues.add(6);
		uniqueValues.add(7);
		uniqueValues.add(7);
		uniqueValues.add(9);
		
		System.out.println(uniqueValues);
		
		for (int value2 : uniqueValues) {
			
			System.out.println(value2);
		}
		
		Iterator<Integer> uIt = uniqueValues.iterator();
		while(uIt.hasNext()) {
			
			int value2 = uIt.next();
			System.out.println(value2);
		}
		
		String lorem = "abbcabcde";
		Map<Character, Integer> charFreq = new HashMap<>();
		Map<Character, Integer> charFreq2 = new HashMap<>();
		
		charFreq.put('z', 10);
		charFreq.put('a', 5);
		
		for (Character c : lorem.toLowerCase().toCharArray()) {
			
			if (charFreq.containsKey(c)) {
				
				charFreq.put(c, charFreq.get(c) + 1);
			} else {
				
				charFreq.put(c, 1);
			}
		}
		
		System.out.println(charFreq);
		
		for (Character key : charFreq.keySet()) {
			
			int value2 = charFreq.get(key);
			System.out.println(key + " --> " + value2);
		}
	}
}









