package org.java;

import java.util.Scanner;

import org.java.blog.User;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = null;
		
		try {
			
			in = new Scanner(System.in);
			
			System.out.print("Username: ");
			String username = in.nextLine();
			
			System.out.print("Password: ");
			String password = in.nextLine();
			
			User u = new User(username, password);
			System.out.println("User: " + u);
		} catch (Exception e) {
			
			System.out.println("Error: " + e.getMessage());
		} finally {

			System.out.println("finally");
			
			if (in != null) 
				in.close();
		}
		
		System.out.println("The end");
	}
}
