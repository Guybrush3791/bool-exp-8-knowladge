package org.lessons.java.christmas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
//		versioneNoBonus();
		versioneBonus();
	}
	
	public static void versioneNoBonus() {
		
		Scanner in = new Scanner(System.in);
		
		List<String> whishes = new ArrayList<>();
		while(true) {
			
			System.out.println("Numero regali presenti: " + whishes.size());
			System.out.print("Vuoi inserire un nuovo regalo? [y/n]");
			
			String userValue = in.nextLine();
			
			if (!userValue.equals("y")) break;
			
			System.out.print("Nome regalo: ");
			userValue = in.nextLine();
			
			whishes.add(userValue);
		}
		
		in.close();
		
		// ORDINAMENTO EZ: V1
//		Collections.sort(whishes);
//		System.out.println(whishes);
		
		// ORDINAMENTO EZ: V2
		whishes.sort(Comparator.comparing(w -> w));
		System.out.println(whishes);
	}
	public static void versioneBonus() {
		
		Scanner in = new Scanner(System.in);
		
		List<Whish> whishes = new ArrayList<>();
		while(true) {
			
			System.out.println("Numero regali presenti: " + whishes.size());
			System.out.print("Vuoi inserire un nuovo regalo? [y/n]");
			
			String userValue = in.nextLine();
			
			if (!userValue.equals("y")) break;
			
			System.out.print("Nome regalo: ");
			String whishName = in.nextLine();
			
			System.out.print("Destinatario regalo: ");
			String whishReceiver = in.nextLine();
			
			whishes.add(new Whish(whishName, whishReceiver));
		}
		
		System.out.println("Ordinare per [n]ome o [d]estinatario? [n/d]");
		String userValue = in.nextLine();
		
		in.close();
		
		if (userValue.equals("n")) {
			
			Collections.sort(whishes, Comparator.comparing(w -> w.getName()));
		} else {
			
			Collections.sort(whishes, Comparator.comparing(w -> w.getReceiver()));
		}
		
		System.out.println(whishes);
	}
}
