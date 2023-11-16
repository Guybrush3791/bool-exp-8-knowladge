package org.java.pojo;

import org.java.pojo.inter.Colorized;
import org.java.pojo.inter.Polygon;

public class Square implements Polygon, Colorized {

	int x;
	String color;
	
	public Square(int x, String color) {
		
		setX(x);
		setColor(color);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int getPerim() {
			
		return getX() * 4;
	}

	@Override
	public int getArea() {
		
		return getX() * getX();
	}

	@Override
	public String toString() {
		
		return getX() + ": " + getPerim() + " - " + getArea();
	}
}
