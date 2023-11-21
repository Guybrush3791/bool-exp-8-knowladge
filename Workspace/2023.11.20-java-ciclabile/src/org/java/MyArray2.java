package org.java;

import java.util.Arrays;

public class MyArray2 {

	int index = 0;
	Integer[] values;
	
	public MyArray2() {
		
		setValues(new Integer[0]);
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Integer[] getValues() {
		return values;
	}
	public void setValues(Integer[] values) {
		this.values = values;
	}
	
	public int getElementoSuccessivo() {
		
		return getValues()[index++];
	}
	public boolean hasAncoraElementi() {
		
		return index < getValues().length;
	}
	public void addElemento(int value) {
		
		Integer[] newValues = new Integer[getValues().length + 1];
		for (int x=0;x<getValues().length;x++) {
			
			newValues[x] = getValues()[x];
		}
		newValues[getValues().length] = value;
		
		setValues(newValues);
	}
	
	@Override
	public String toString() {
		
		return Arrays.asList(getValues()).toString();
	}
}
