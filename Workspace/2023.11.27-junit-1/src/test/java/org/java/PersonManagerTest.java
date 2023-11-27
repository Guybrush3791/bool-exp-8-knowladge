package org.java;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class PersonManagerTest {

	private static PersonManager pm = null;
	
	@BeforeAll
	public static void setup() {
		
		pm = new PersonManager();
	}
	
	@Test
	public void goodDataPersonTest() {
		
		String name = "Guybrush";
		int age = 30;
		
		assertDoesNotThrow(() -> pm.addPerson(name, age), "Nessuna eccezione deve essere scatenata con dati corretti");
	}
	
	@Test
	public void emptyNamePersonTest() {
		
		String name = "";
		int age = 30;
		
		assertThrows(Exception.class,
				() -> pm.addPerson(name, age), 
				"Eccezione attesa con nome vuoto");
	}
	
	@Test
	public void nullNamePersonTest() {
		
		String name = null;
		int age = 30;
		
		assertThrows(Exception.class,
				() -> pm.addPerson(name, age), 
				"Eccezione attesa con nome vuoto");
	}
	
	@RepeatedTest(10)
	public void negativeAgePersonTest() {
		
		Random rnd = new Random();
		
		String name = "Guybrush";
		int age = -1 - rnd.nextInt(100);
		
		assertThrows(Exception.class,
				() -> pm.addPerson(name, age), 
				"Eccezione attesa con nome vuoto");
	}
}
