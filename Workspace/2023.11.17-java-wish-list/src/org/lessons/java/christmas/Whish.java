package org.lessons.java.christmas;

public class Whish {

	private String name;
	private String receiver;
	public Whish(String name, String receiver) {
		
		setName(name);
		setReceiver(receiver);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public String toString() {
		
		return getName() + " for " + getReceiver();
	}
}
