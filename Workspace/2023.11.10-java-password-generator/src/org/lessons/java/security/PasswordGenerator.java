package org.lessons.java.security;

public class PasswordGenerator {

	public static void main(String[] args) {
		
		String name = "Mario";
		String lastname = "Rossi";
		String color = "Purple";
		int birthYear = 1999;
		int birthMonth = 5;
		int birthDay = 12;
		
		String pws = name + "-" + lastname + "-"
					+ color + "-" + (birthYear + birthMonth + birthDay);
		System.out.println("Pws: " + pws);
	}
}
