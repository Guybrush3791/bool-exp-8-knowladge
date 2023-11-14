package org.java;

import java.util.Random;

import org.java.shape.Parallelepiped;
import org.java.shape.Rettangolo;

public class Main {

	static final int RETT_COUNT = 10;
	public static void main(String[] args) {
		
		Random rnd = new Random();
		Rettangolo[] rettangoli = new Rettangolo[RETT_COUNT];
		
		for (int x=0;x<RETT_COUNT;x++) {

			Rettangolo r = new Rettangolo(rnd.nextInt(10), rnd.nextInt(10));
			rettangoli[x] = r;
			
			System.out.println("Rettangolo " + r + "\n----------------------\n");
		}
		
		int maxArea = Integer.MIN_VALUE;
		Rettangolo maxAreaR = null;
		
		for (int x=0;x<RETT_COUNT;x++) {
			
			Rettangolo r = rettangoli[x];
			
			if (r.getArea() > maxArea) {
				
				maxArea = r.getArea();
				maxAreaR = r;
			}
		}
		
		System.out.println("Max area: " + maxArea);
		System.out.println("Rettangolo con area piu' grande:\n" + maxAreaR);
		
		System.out.println("\n----------------------\n");
		
		Parallelepiped p1 = new Parallelepiped(1, 2, 3);
		System.out.println("Parallelepipedo " + p1);
		
		System.out.println("\n----------------------\n");
		
		Rettangolo[] shapes = new Rettangolo[3];
		shapes[0] = new Rettangolo(1, 2);
		shapes[1] = new Parallelepiped(3, 4, 5);
		shapes[2] = new Rettangolo(6, 7);
		
		int sumArea = 0;
		for (int x=0;x<shapes.length;x++) {
			
			Rettangolo shape = shapes[x];
			sumArea += shape.getArea();
		}
		
		System.out.println("Somma area: "+ sumArea);
	}
}
