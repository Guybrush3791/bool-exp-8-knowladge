package org.java;

public class Test1 {

	public static void main(String[] args) {

		Auto a1 = new Auto("blu", "citroen");
		
		a1.setColore("");
//		a1.marca = "citroen";
//		a1.annoProduzione = 2009;
		
		Auto a2 = new Auto("giallo", "ford", 2020);
		Auto a3 = new Auto("grigio", "nissan", 2021);
		
//		a2.colore = "giallo";
//		a2.marca = "ford";
//		a2.annoProduzione = 2020;
		
		System.out.println("A1:");
		System.out.println("colore: " + a1.getColore());
		System.out.println("marca: " + a1.getMarca());
		System.out.println("anno produzione: " + a1.getAnnoProduzione());
		
		System.out.println("---------------------------------------");
		
		System.out.println("A2:");
		System.out.println("colore: " + a2.getColore());
		System.out.println("marca: " + a2.getMarca());
		System.out.println("anno produzione: " + a2.getAnnoProduzione());
		
		System.out.println("---------------------------------------");
		
		a1.parti();
		a2.parti();
		a1.cambiaColoreEAnno("magenta");
		a1.parti();
		System.out.println(a1.getAnnoProduzione());
		System.out.println(a1.getColoreEMarcaStr());
		
		System.out.println("Dimensione parco auto: " + Auto.AutoCounter);
	}
}
