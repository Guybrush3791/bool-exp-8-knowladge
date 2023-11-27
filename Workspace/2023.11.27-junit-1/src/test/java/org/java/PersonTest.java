package org.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

	private Person p;
	
	@BeforeEach
	public void init() throws Exception {
		
		p = new Person("Guybrush", 30);
	}
	
	@Test
	public void getSetNameTest() throws Exception {
		
		final String NAME = "Franco";
		p.setName(NAME);
		
		assertEquals(NAME, p.getName(), "Nome non corrispondente");
	}
	
	@Test
	public void getSetAgeTest() throws Exception {
		
		final int AGE = 25;
		p.setAge(AGE);
		
		assertEquals(AGE, p.getAge(), "Eta' non conforme");
		
	}
}
