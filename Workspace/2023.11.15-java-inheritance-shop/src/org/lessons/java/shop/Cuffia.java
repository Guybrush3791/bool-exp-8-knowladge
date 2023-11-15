package org.lessons.java.shop;

public class Cuffia extends Prodotto {

	private String color;
	private boolean wireless;
	
	public Cuffia(String nome, String descrizione, float prezzo, float iva,
				 String color, boolean wireless) {
		
		super(nome, descrizione, prezzo, iva);

		setColor(color);
		setWireless(wireless);
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isWireless() {
		return wireless;
	}
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}
	
	@Override
	public float getFullPrezzo(boolean fidelity) {
		
		if (!fidelity) return getFullPrezzo();
		
		return !isWireless()
				? getFullPrezzo() * .93f 
				: super.getFullPrezzo(fidelity);
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
			 + "Colore: " + getColor() + "\n"
	 		 + "Wireless: " + (isWireless() ? "yes" : "no");
	}
}
