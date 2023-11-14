package org.java.shape;

public class Rettangolo {

	private int w;
	private int h;
	
	public Rettangolo(int w, int h) {
		
		setW(w);
		setH(h);
	}
	
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	
	public int getArea() {
		
		return getW() * getH();
	}
	public int getPer() {
		
		return 2 * (getW() + getH());
	}
	
	@Override
	public String toString() {
		
		return getW() + "x" + getH() + ":\n"
				+ "area: " + getArea() + "\n"
				+ "perimetro: " + getPer();
	}
}
