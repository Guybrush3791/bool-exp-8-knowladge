package org.lessons.java.shop;

public class Televisore extends Prodotto {

	private int diagonal;
	private boolean smart;
	
	public Televisore(String nome, String descrizione, float prezzo, float iva,
					  int diagonal, boolean smart) {
		
		super(nome, descrizione, prezzo, iva);
		
		setDiagonal(diagonal);
		setSmart(smart);
	}
	
	public int getDiagonal() {
		return diagonal;
	}
	public void setDiagonal(int diagonal) {
		this.diagonal = diagonal;
	}
	public boolean isSmart() {
		return smart;
	}
	public void setSmart(boolean smart) {
		this.smart = smart;
	}
	
	@Override
	public float getFullPrezzo(boolean fidelity) {
		
		if (!fidelity) return getFullPrezzo();
		
		return !isSmart()
				? getFullPrezzo() * .90f 
				: super.getFullPrezzo(fidelity);
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
				+ "Diagonal: " + getDiagonal() + "'\n"
				+ "Smart: " + (isSmart() ? "yes" : "no");
	}
}
