package org.java.pojo;

import org.java.pojo.abs.Animale;
import org.java.pojo.inter.IVolante;

public class Passerotto extends Animale implements IVolante {

	@Override
	public void verso() {
		
		System.out.println("Chip chip");
	}
	@Override
	public void mangia() {
		
		System.out.println("Semi");
	}
	@Override
	public void vola() {
		
		System.out.println("Sto volando!!!");
	}
}
