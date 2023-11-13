
package org.java;

public class Snack8 {

	public static void main(String[] args) {
		
		final String str = "Gabbiano";
		
		String updatedStr = "";
		for (int x=0;x<str.length();x++) {
			
			char c = str.charAt(x);
			
			if (c == 'a') c = 'o';
			else if (c == 'o') c = 'a';
			
			updatedStr += c;
		}
		
		System.out.println("Stringa originale: " + str);
		System.out.println("Stringa modificata: " + updatedStr);
	}
}
