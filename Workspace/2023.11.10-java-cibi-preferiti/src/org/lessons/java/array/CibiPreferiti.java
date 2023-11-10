package org.lessons.java.array;

public class CibiPreferiti {

	public static void main(String[] args) {
		
		String[] cibi = { "cibo 1", "cibo 2", "cibo 3", "cibo 4", "cibo 5", "cibo 6" };
		int lng = cibi.length;
		
		System.out.println("Numero cibi preferiti: " + lng);
		System.out.println("Cibo top: " + cibi[0]);
		System.out.println("Cibo top ma non troppo: " + cibi[lng - 1]);
		
		// Bonus
		if (cibi.length % 2 == 0) {
			
			System.out.println("Cibi mediani: " + cibi[lng/2 - 1] + ", " + cibi[lng/2]);
		} else {
			
			System.out.println("Cibo mediano: " + cibi[lng/2]);
		}
	}
}
