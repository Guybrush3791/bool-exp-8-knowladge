package org.lessons.java.shop;

public class Main {
	
	public static void main(String[] args) {
		
		Prodotto p1 = new Prodotto("prodotto1", "desc1", 100, 20);
		
		String strP1 = "Log di p1:\n" + p1;
		System.out.println(strP1);
	}
}
