package org.java.pojo;

import org.java.pojo.inter.Polygon;

public class TriangRect implements Polygon {

	int w;
	int h;
	
	public TriangRect(int w, int h) {
		
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
	
	@Override
	public int getPerim() {
		
		return getW() + getH() + getIpot();
	}
	@Override
	public int getArea() {
		
		return getW() * getH() / 2;
	}
	
	@Override
	public String toString() {
		
		return getW() + "x" + getH() + ": " + getPerim() + " - " + getArea();
	}
	
	private int getIpot() {
		
		return (int) Math.sqrt(getW() * getW() + getH() * getH());
	}
}