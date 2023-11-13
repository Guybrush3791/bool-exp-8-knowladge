package org.java;

import java.util.Arrays;

public class Snack9 {

	public static void main(String[] args) {
		
		final Integer[] values = {1, 2, 3, 4, 5};
		
		int pairIndex = 0;
		int oddIndex = 0;
		
		final Integer[] pairValues = new Integer[values.length];
		final Integer[] oddValues = new Integer[values.length];
		
		for (int x=0;x<values.length;x++) {
			
			int value = values[x];
			
			if (value % 2 == 0)
				pairValues[pairIndex++] = value;
			else
				oddValues[oddIndex++] = value;
		}
		
		System.out.println("Valori originali: " + Arrays.asList(values));
		
		System.out.println("Valori pari: " + Arrays.asList(pairValues));
		System.out.print("Valori pari: [");
		for (int x=0;x<pairIndex;x++) {
			
			int pairValue = pairValues[x];
			System.out.print(pairValue+ ", ");
		}
		System.out.println("]");
		
		System.out.print("Valori dispari: [");
		for (int x=0;x<oddIndex;x++) {
			
			int oddValue = oddValues[x];
			System.out.print(oddValue+ ", ");
		}
		System.out.println("]");
	}
}
