package org.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.java.blog.User;
import org.java.blog.exception.PasswordException;

public class ExceptionFileEx {

	static final File mioFile = new File("/tmp/tmp/test.txt");
	
	public static void main(String[] args) {

		// EXCEPTION		
		Scanner in = new Scanner(System.in);
		
		System.out.print("User da creare: ");
		String strUserCount = in.nextLine();
		int userCount = Integer.valueOf(strUserCount);
		
		int userIndex = 0;
		User[] users = new User[userCount];
		while(userIndex < userCount) {
			
			System.out.println("Utente " + (userIndex + 1));
			System.out.print("Username: ");
			String username = in.nextLine();
			
			System.out.print("Password: ");
			String password = in.nextLine();
			
			User user = null;
			
			try {
				
				user = new User(username, password);
				
				users[userIndex++] = user;
			} catch (PasswordException e) {
				
				System.out.println("Error in password: " + e.getMessage());
			} catch (Exception e) {

				System.out.println("Errore in username: " + e.getMessage());
			}
		}
		
		System.out.println(Arrays.asList(users));

		// FILE
		// --WRITE
		FileWriter myWriter = null;
		
		try {
			
			myWriter = new FileWriter(mioFile);
			
			for (int x=0;x<users.length;x++) {
				
				User u = users[x];
				
				myWriter.write(u.getUsername() + "\n");
			}
		} catch (IOException e) {
			
			System.out.println("Error writing file: " + e.getMessage());
		} finally {
			
			if (myWriter != null)
				try {
					myWriter.close();
				} catch (IOException e) { }
		}	
		
		// --READ
		Scanner reader = null;
		try {
			
			reader = new Scanner(mioFile);
			
			while (reader.hasNextLine()) {
			   String data = reader.nextLine();
			   
			   if (data.toLowerCase().startsWith("g"))
				   System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			
			System.out.println("Error reading file: " + e.getMessage());
		} finally {
			
			if (reader != null)
				reader.close();
		}
	}
}
