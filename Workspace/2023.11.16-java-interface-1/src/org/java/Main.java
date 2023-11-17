package org.java;


import java.awt.dnd.DropTargetContext;
import java.util.Random;

import org.java.pojo.Rectangle;
import org.java.pojo.Square;
import org.java.pojo.TriangRect;
import org.java.pojo.inter.Colorized;
import org.java.pojo.inter.Polygon;

public class Main {

	public static void main(String[] args) {
		
		Square s1 = new Square(5, "yellow");
		System.out.println(s1);
		System.out.println("\n--------------------------------------\n");
		
		Rectangle r1 = new Rectangle(5, 6, "brown");
		System.out.println(r1);
		System.out.println("\n--------------------------------------\n");
		
		TriangRect tr1 = new TriangRect(5, 7);
		System.out.println(tr1);
		System.out.println("\n--------------------------------------\n");
		
		Polygon[] polygons = new Polygon[3];
		polygons[0] = s1;
		polygons[1] = r1;
		polygons[2] = tr1;
		
		int sumPerim = 0;
		int sumArea = 0;
		for (int x=0;x<polygons.length;x++) {
			
			Polygon p = polygons[x];
			
			sumPerim += p.getPerim();
			sumArea += p.getArea();
		}
		
		getPolygonArea(tr1);
		getColorizedColor(tr1);
		
		System.out.println("sum perim: " + sumPerim);
		System.out.println("sum area: " + sumArea);
		System.out.println("\n--------------------------------------\n");
		
		Colorized[] colorizeds = new Colorized[2];
		colorizeds[0] = s1;
		colorizeds[1] = r1;
		
		for (int x=0;x<colorizeds.length;x++) {
			
			Colorized c = colorizeds[x];
			
			System.out.println("color " + (x+1) + ": " + c.getColor());
		}
	}
	
	public static int getPolygonArea(Polygon p) {
		
		return p.getArea();
	}
	public static String getColorizedColor(Colorized c) {
		
		return c.getColor();
	}
	
	public static Polygon getRandomShape() {
		
		Random rnd = new Random();
		int value = rnd.nextInt(10);
		
		if (value % 2 == 0) {
			
			return new Square(rnd.nextInt(10), "yellow");
		} 
		
		return new Rectangle(rnd.nextInt(10), rnd.nextInt(10), "blue");
	}
}
















