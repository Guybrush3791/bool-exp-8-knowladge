package org.java.pojo;

public class Rectangle extends Square {

	int y;
	
	public Rectangle(int x, int y, String color) {
		
		super(x, color);
		
		setY(y);
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int getPerim() {
		
		return 2 * (getX() + getY());
	}
	@Override
	public int getArea() {
		
		return getX() * getY();
	}
	
	@Override
	public String toString() {
		
		return getY() + "x" + super.toString();
	}
}
