package org.java;

public class Person {

	private String name;
	private int age;
	public Person(String name, int age) throws Exception {
		
		setName(name);
		setAge(age);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws Exception {
		
		if (name == null || name.isEmpty())
			throw new Exception("Name can't be empty or null");
		
//		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception {
		
		if (age < 0)
			throw new Exception("Age can't be negative");
		
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return getName() + " - " + getAge();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Person)) return false;
		
		Person p = (Person) obj;
		
		return getName().equals(p.getName())
				&& getAge() == p.getAge();
	}
}
