package org.java.landeria.pojo;

public class Tank {

	public enum TankTypology { DETERGENT, SOFTENER };
	
	private static final int DETERGENT_CAPACITY = 1000;
	private static final int SOFTENER_CAPACITY = 500;
	
	private int capacity;
	private int level;
	
	public Tank(TankTypology tankTypology, int level) {
		
		switch(tankTypology) {
		
			case DETERGENT: setCapacity(DETERGENT_CAPACITY); break;
			case SOFTENER: setCapacity(SOFTENER_CAPACITY); break;
		}
		
		setLevel(level);
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}	
	public void addLevel(int level) {
		
		setLevel(getLevel() + level);
	}
	
	@Override
	public String toString() {
		
		return getLevel() + "/" + getCapacity();
	}
}
