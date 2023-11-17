package org.java.pojo;

import org.java.pojo.abs.Animale;
import org.java.pojo.inter.INuotante;

public class Cane extends Animale implements INuotante {

	@Override
	public void verso() {
		
		System.out.println("Bau bau");
	}
	@Override
	public void mangia() {
		
		System.out.println("Crocchette");
	}
	@Override
	public void nuota() {
		
		System.out.println("Sto nuotando!!!");
	}
}
