package org.java;

import org.java.pojo.Aquila;
import org.java.pojo.Cane;
import org.java.pojo.Delfino;
import org.java.pojo.Passerotto;
import org.java.pojo.abs.Animale;
import org.java.pojo.inter.INuotante;
import org.java.pojo.inter.IVolante;

public class Main {

	public static void main(String[] args) {
		
		Cane c1 = new Cane();
		Passerotto p1 = new Passerotto();
		Aquila a1 = new Aquila();
		Delfino d1 = new Delfino();
		
		Animale[] animali = { c1, p1, a1, d1 };
		
		for (int x=0;x<animali.length;x++) {
			
			Animale a = animali[x];
			
			System.out.println(a.getClass().getSimpleName() + ":");
			a.dormi();
			a.verso();
			a.mangia();
			
			System.out.println("\n-----------------------------\n");
		}
		
		IVolante[] volanti = { p1, a1 };
		INuotante[] nuotanti = { c1, d1 };
		
		for (int x=0;x<volanti.length;x++) {
			
			IVolante volante = volanti[x];
			System.out.println(volante.getClass().getSimpleName() + ":");
			faiVolate(volante);
			
			System.out.println("\n-----------------------------\n");
		}
		for (int x=0;x<nuotanti.length;x++) {
			
			INuotante nuotante = nuotanti[x];
			System.out.println(nuotante.getClass().getSimpleName() + ":");
			faiNuoatare(nuotante);
			
			System.out.println("\n-----------------------------\n");
		}
	}
	
	public static void faiVolate(IVolante volante) {
		
		volante.vola();
	}
	public static void faiNuoatare(INuotante nuotante) {
		
		nuotante.nuota();
	}
}
