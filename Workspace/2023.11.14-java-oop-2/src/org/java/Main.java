package org.java;

import org.java.media.Film;

public class Main {

	public static void main(String[] args) {
		
		Film f = new Film("Matrix", new String[] {"act1", "act2"}, 120);
		f.riproduci();
	}
}
