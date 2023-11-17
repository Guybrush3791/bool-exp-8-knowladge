package org.java.pojo;

import org.java.pojo.abs.Animale;
import org.java.pojo.inter.IVolante;

public class Aquila extends Animale implements IVolante {

	@Override
	public void verso() {
		
		System.out.println("Stride");
	}
	@Override
	public void mangia() {
		
		System.out.println("Carcasse");
	}
	@Override
	public void vola() {
		
		System.out.println("Sto volando!!!");
	}
}
