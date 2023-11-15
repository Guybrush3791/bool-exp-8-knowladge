package org.lessons.java;

import java.util.Arrays;
import java.util.Scanner;

import org.lessons.java.shop.Cuffia;
import org.lessons.java.shop.Prodotto;
import org.lessons.java.shop.Smartphone;
import org.lessons.java.shop.Televisore;

public class Carrello {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int indexProdotti = 0;
		Prodotto[] prodotti = new Prodotto[20];
		
		String userValue = null;
		int intUserValue = 0;
		while (true) {
			
			System.out.println("Inserire prodotto:\n"
					+ "1 - si'\n"
					+ "2 - no");
			userValue = in.nextLine();
			intUserValue = Integer.valueOf(userValue);
			
			if (intUserValue == 2) break;
			if (intUserValue != 1) continue;
			
			System.out.println("Tipologia prodotto:\n"
					+ "1 - Smartphone\n"
					+ "2 - Televisore\n"
					+ "3 - Cuffia");
			userValue = in.nextLine();
			intUserValue = Integer.valueOf(userValue);
			
			if (intUserValue < 1 || intUserValue > 3) continue;
			
			System.out.print("Nome: ");
			String nome = in.nextLine();
			
			System.out.print("Descrizione: ");
			String descrizione = in.nextLine();
			
			System.out.print("Prezzo: ");
			String strPrezzo = in.nextLine();
			float prezzo = Float.valueOf(strPrezzo);
			
			System.out.print("Iva: ");
			String strIva = in.nextLine();
			float iva = Float.valueOf(strIva);
			
			Prodotto p = null;
			switch(intUserValue) {
			
				case 1:

					System.out.print("Codice IMEI: ");
					String codeImei = in.nextLine();
					
					System.out.print("Memory: ");
					String strMemory = in.nextLine();
					int memory = Integer.valueOf(strMemory);
					
					p = new Smartphone(nome, descrizione, prezzo, iva, codeImei, memory);
				break;
				
				case 2:
					
					System.out.print("Diagonal: ");
					String strDiagonal = in.nextLine();
					int diagonal = Integer.valueOf(strDiagonal);
					
					System.out.print("Smart yes/no: ");
					String strSmart = in.nextLine();
					boolean smart = strSmart.equals("yes");
					
					p = new Televisore(nome, descrizione, prezzo, iva, diagonal, smart);
				break;
				case 3:
					// String color, boolean wireless
					
					System.out.print("Color: ");
					String color = in.nextLine();
					
					System.out.print("Wireless yes/no: ");
					String strWireless = in.nextLine();
					boolean wireless = strWireless.equals("yes");
					
					p = new Cuffia(nome, descrizione, prezzo, iva, color, wireless);					
				break;
			}
			
			prodotti[indexProdotti++] = p;
		}
		
		System.out.println(Arrays.asList(prodotti));
		
		System.out.print("Fidelity card yes/no: ");
		userValue = in.nextLine();
		boolean fidelity = userValue.equals("yes");
		
		float sum = 0;
		for (int x=0;x<indexProdotti;x++) {
			
			Prodotto p = prodotti[x];
			float finalPrice = p.getFullPrezzo(fidelity);
			
			sum += finalPrice; 
			
			System.out.println("Name: " + p.getNome());
			System.out.println("Prezzo finale: " + finalPrice);
			System.out.println("\n-------------------------\n");
		}
		
		System.out.println("Grand total: " + sum);
	}
}
