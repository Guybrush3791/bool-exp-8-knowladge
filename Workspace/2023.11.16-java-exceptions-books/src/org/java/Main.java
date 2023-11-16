package org.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Numero libri: ");
		String strBookCount = in.nextLine();
		int bookCount = Integer.valueOf(strBookCount);
		
		int bookIndex = 0;
		Book[] books = new Book[bookCount];
		while (bookIndex < bookCount) {
			
			System.out.print("Titolo: ");
			String bookTitle = in.nextLine();
			
			System.out.print("Numbero pagine: ");
			String strBookPageCount = in.nextLine();
			int bookPageCount = Integer.valueOf(strBookPageCount);
			
			System.out.print("Autore: ");
			String bookAuthor = in.nextLine();
			
			System.out.print("Editore: ");
			String bookEditor = in.nextLine();
			
			try {
				
				Book book = new Book(bookTitle, bookPageCount, bookAuthor, bookEditor);
				books[bookIndex++] = book;
			} catch (Exception e) {
				
				System.out.println("Errore nella creazione, si prega di riprovare");
				System.out.println("Errore: " + e.getMessage());
			}
		}
		in.close();
		
		File f = new File("/tmp/tmp/book.txt");
		
		FileWriter myWriter = null;
		try {
			
			myWriter = new FileWriter(f);
			
			for (int x=0;x<bookCount;x++) {
				
				Book book = books[x];
				
				myWriter.write(book.getTitle() + "\n"
						+ book.getPageCount() + "\n"
						+ book.getAuthor() + "\n"
						+ book.getEditor() + "\n");
			}
			
			
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
			
			reader = new Scanner(f);
			
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
	}
}
