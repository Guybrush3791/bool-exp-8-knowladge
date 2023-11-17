package org.java.pojo;

import org.java.pojo.abs.Animale;
import org.java.pojo.inter.INuotante;

public class Delfino extends Animale implements INuotante {

	@Override
	public void verso() {
	
		System.out.println("Squikie");
	}
	@Override
	public void mangia() {
		
		System.out.println("Pesci");
	}
	@Override
	public void nuota() {
		
		System.out.println("Sto nuotando!!!");
	}
}
