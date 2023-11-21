package org.java;

public class Main {

	public static void main(String[] args) {
		
		Integer[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		MyArray2 ma2 = new MyArray2();
		for (Integer v : values)
			ma2.addElemento(v);
		
//		MyArray ma = new MyArray(values);
		
		while(ma2.hasAncoraElementi()) {
			
			System.out.println(ma2.getElementoSuccessivo());
		}
		
		System.out.println("The end");
	}
}
