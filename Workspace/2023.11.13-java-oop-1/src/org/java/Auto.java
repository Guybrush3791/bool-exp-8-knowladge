package org.java;

public class Auto {

	public static int AutoCounter = 0;
	
	private String colore;
	private String marca;
	private int annoProduzione;
	
//	public Auto() { }
	public Auto(String colore, String marca) {
		
		this(colore, marca, 2046);
	}
	public Auto(String colore, String marca, int annoProduzione) {
		
		AutoCounter++;
//		this.colore = colore;
//		this.marca = marca;
//		this.annoProduzione = annoProduzione;
		setColore(colore);
		setMarca(marca);
		setAnnoProduzione(annoProduzione);
	}
	
	public String getColore() {
		
		return colore;
	}
	public void setColore(String colore) {
		
		if (colore.isEmpty() || colore.length() < 3) {
			return;
		}
		
		this.colore = colore;
	}
	public String getMarca() {
		
		return marca;
	}
	public void setMarca(String marca) {
		
		this.marca = marca;
	}
	public int getAnnoProduzione() {
		
		return annoProduzione;
	}
	public void setAnnoProduzione(int annoProduzione) {
		
		this.annoProduzione = annoProduzione;
	}
	
	public void parti() {
		
		System.out.println("L'auto " + this.colore + " sta partendo");
	}
	public void cambiaColoreEAnno(String colore) {
		cambiaColoreEAnno(colore, 2023);
	}
	public void cambiaColoreEAnno(String colore, int annoProduzione) {
		
		this.colore = colore;
		this.annoProduzione = annoProduzione;
	}
	
	public String getColoreEMarcaStr() {
		
		return colore + " " + marca;
	}
}
