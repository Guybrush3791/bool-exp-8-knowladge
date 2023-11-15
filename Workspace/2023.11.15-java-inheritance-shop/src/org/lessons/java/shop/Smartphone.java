package org.lessons.java.shop;

public class Smartphone extends Prodotto {

	private String codeImei;
	private int memory;
	
	public Smartphone(String nome, String descrizione, float prezzo, float iva,
					 String codeImei, int memory) {
		
		super(nome, descrizione, prezzo, iva);
		
		setCodeImei(codeImei);
		setMemory(memory);
	}

	public String getCodeImei() {
		return codeImei;
	}
	public void setCodeImei(String codeImei) {
		this.codeImei = codeImei;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}

	@Override
	public float getFullPrezzo(boolean fidelity) {
		
		if (!fidelity) return getFullPrezzo();
		
		return getMemory() < 32 
				? getFullPrezzo() * .95f 
				: super.getFullPrezzo(fidelity);
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
			 + "IMEI: " + getCodeImei() + "\n"
	 		 + "Memory: " + getMemory() + "GB";
	}
}
