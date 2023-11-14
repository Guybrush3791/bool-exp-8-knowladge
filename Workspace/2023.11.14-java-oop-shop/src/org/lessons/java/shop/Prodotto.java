package org.lessons.java.shop;

import java.util.Random;

public class Prodotto {

	private int codice;
	private String nome;
	private String descrizione;
	private float prezzo;
	private float iva;
	
	public Prodotto(String nome, String descrizione, float prezzo, float iva) {
		
		generateNewRandomCode();
		
		setNome(nome);
		setDescrizione(descrizione);
		setPrezzo(prezzo);
		setIva(iva);
	}
	
	private void generateNewRandomCode() {
		
		Random rnd = new Random();
		
		setCodice(rnd.nextInt(0, 100)); //Integer.MAX_VALUE));
	}
	
	public int getCodice() {
		
		return codice;
	}
	private void setCodice(int codice) {
		
		// controlli di integrita'
		this.codice = codice;
	}
	public String getNome() {
		
		return nome;
	}
	public void setNome(String nome) {
		
		this.nome = nome;
	}
	public String getDescrizione() {
		
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		
		this.descrizione = descrizione;
	}
	public float getPrezzo() {
		
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		
		this.prezzo = prezzo;
	}
	public float getIva() {
		
		return iva;
	}
	public void setIva(float iva) {
		
		this.iva = iva;
	}

	public String getPaddedCodice() {
		
		return String.format("%08d", getCodice());
	}
	public float getFullPrezzo() {
		
		return getPrezzo() / 100 * (100 + getIva());
	}
	public String getFullName() {
		
		return getPaddedCodice() + "-" + getNome();
	}

	@Override
	public String toString() {
		
		return "[" + getFullName() + "] " + getNome() + "\n"
				+ "prezzo: " + getPrezzo() + " --> " + getFullPrezzo() + "\n"
				+ "iva: " + ((int) getIva()) + "%\n"
				+ "descrizione:\n" + getDescrizione();				
	}
}
