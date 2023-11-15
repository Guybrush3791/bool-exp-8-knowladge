package org.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		
		File mioFile = new File("/tmp/tmp/test.txt");

		FileWriter myWriter = null;
		try {
			
			myWriter = new FileWriter(mioFile);
			myWriter.write("Quanto amo gestire i file in Java!");
		} catch (IOException e) {
			
			System.out.println("Error writing file: " + e.getMessage());
		} finally {
			
			if (myWriter != null)
				try {
					myWriter.close();
				} catch (IOException e) { }
		}		
		 
		Scanner reader = null;
		try {
			
			reader = new Scanner(mioFile);
			
			while (reader.hasNextLine()) {
			   String data = reader.nextLine();
			   System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			
			System.out.println("Error reading file: " + e.getMessage());
		} finally {
			
			if (reader != null)
				reader.close();
		}
		 
		System.out.println("\n----------------------------\n");
		System.out.println("The end");
	}
}
