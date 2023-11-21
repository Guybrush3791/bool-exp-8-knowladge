package org.java;

import java.util.Arrays;

public class MyArray {
	
	int index = 0;
	Integer[] values;
	
	public MyArray(Integer[] values) {
		
		setValues(values);
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
	
	@Override
	public String toString() {
		
		return Arrays.asList(getValues()).toString();
	}
}
