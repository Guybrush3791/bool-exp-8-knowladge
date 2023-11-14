package org.java.shape;

public class Parallelepiped extends Rettangolo {

	private int p;
	
	public Parallelepiped(int w, int h, int p) {
		
		super(w, h);
		
		setP(p);
	}
	
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	
	@Override
	public int getArea() {
		
		return super.getArea() * getP();
	}
	@Override
	public int getPer() {
		
		return super.getPer() + 2 * (getW() * getP() + getH() * getP());
	}

	public void sayHello() {
		
		System.out.println("Hello, World!");
	}
	
	@Override
	public String toString() {
		
		sayHello();
		
		return getP() + "x" + super.toString();
	}
}
