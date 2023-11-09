package org.java;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// interi
			boolean b1 = true; // false
			byte b2 = 10;
			short s1 = 30000;
			int i1 = 50_000_000;
			long l1 = 100_000_000_000L;
			
			// virgola mobile
			float f1 = 10.3F;
			double d1 = 10.33333;
			
			// caratteri
			char c1 = 'd'; // \n e' un carattere
			
//			System.out.println(b1 + "\n" + b2);
//			System.out.println(s1);
//			System.out.println(i1);
//			System.out.println(l1);
//			System.out.println(f1);
//			System.out.println(d1);
//			System.out.println(c1);
			
			// stampo in console
//			System.out.println("stampo con a capo finale");
//			System.out.print("stampo senza a capo finale");
//			System.out.println(" stringa sulla stessa riga");
//			
//			// error
//			System.err.println("stampo errore in rosso 1");
//			System.err.println("stampo errore in rosso 2");
//			System.err.println("stampo errore in rosso 3");
			
			// lettura console
//			Scanner in = new Scanner(System.in);
//			
//			System.out.print("Dimmi una parola: ");
//			String word = in.nextLine();
//			
//			System.out.println("Mi hai scritto la seguente parola: " + word);
//			
//			System.out.print("Dimmi un intero: ");
//			String strValue = in.nextLine();
//			int intValue = Integer.valueOf(strValue);
//			
//			System.out.println("Mi hai scritto il numero: " + intValue);
			
//			int x = 10;
//			if (x > 10) {
//				System.out.println("x gt 10");
//			} else {
//				System.out.println("x le 10");
//			}
			
			Random rnd = new Random(100);
			
//			int rndValue = rnd.nextInt();
//			int rndValueBound = rnd.nextInt(101);
//			int rndValueOriginBound = rnd.nextInt(50, 101);
//			
//			System.out.println("rndValue: " + rndValue);
//			System.out.println("rndValueBound: " + rndValueBound);
//			System.out.println("rndValueOriginBound: " + rndValueOriginBound);
			
//			System.out.println("Float formattato: " + String.format("%.4f", f1));\
			
			int[] arr1 = { 1, 2, 3, 4, 5 };
			System.out.println(arr1[0]);
			arr1[0] = 100;
			System.out.println(arr1[0]);
			
			int[] arr2 = new int[5];
			System.out.println(arr2[0]);
			
			int ind = 0;
			
			arr2[ind++] = 10;
			arr2[ind++] = 20;
			arr2[ind++] = 30;
			arr2[ind++] = 40;
			arr2[ind++] = 50;
			// ...
			int[] arr3 = new int[arr2.length * 2];
			for (int x=0;x<arr2.length;x++) 
				arr3[x] = arr2[x];
			arr3[ind++] = 60;
			arr2 = arr3;
			
			System.out.println(arr2[0]);
			System.out.println(arr2[1]);
			System.out.println(arr2[2]);
			
//				System.out.println(Arrays.asList(arr2));
			
			for (int x=0;x<arr2.length;x++) {
				
				int value = arr2[x];
				System.out.println("value: " + value);
			}
			
			String str = "Hello, World!";
			for (int x=0;x<str.length();x++) {
				
				char c = str.charAt(x);
				System.out.println(c);
			}
			
			int sum = 0;
			while (sum < 100) {
				
				int value = rnd.nextInt(10); 
				sum += value;
				
				System.out.println("value: " + value);
				System.out.println("partial sum: " + sum);
			}
			
			System.out.println("final sum: " + sum);
	}
}
