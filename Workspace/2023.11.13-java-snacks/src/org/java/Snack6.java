package org.java;

public class Snack6 {

	public static void main(String[] args) {
		
		final String STR_VALUE= "253432";
		
//		// VERSIONE 1
//		final char[] DIGITS = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//		
//		int value = 0;
//		for (int x=0;x<STR_VALUE.length();x++) {
//			
//			char cStrValue = STR_VALUE.charAt(x);
//			
//			for (int y=0;y<DIGITS.length;y++) {
//				
//				char cDigit = DIGITS[y];
//				
//				if (cStrValue == cDigit) 
//					value = value * 10 + y;
//			}
//		}
		
		// VERSIONE 2		
		int value = 0;
		for (int x=0;x<STR_VALUE.length();x++) {
			
			char cStrValue = STR_VALUE.charAt(x);
			int intCharStrValue = (int) cStrValue - (int) '0';
			
			value = value * 10 + intCharStrValue;
		}

		System.out.println("str value: " + STR_VALUE);
		System.out.println("int value: " + value);
	}
}
