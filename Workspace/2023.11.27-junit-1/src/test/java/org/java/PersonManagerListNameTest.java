package org.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

public class PersonManagerListNameTest {

	private PersonManager pm = null;
	
	@BeforeEach
	public void init() throws Exception  {
		
		pm = new PersonManager();
		
		pm.addPerson("Guybrush", 30);
		pm.addPerson("Marco", 20);
		pm.addPerson("Francesca", 25);
		pm.addPerson("Marcolino", 35);
		pm.addPerson("Francescana", 40);
	}
	
	@Test
	public void getPeopleByNameMarcoPersonManagerTest() throws Exception {
		
		List<Person> findedPerson = pm.getPeopleByName("marco");		
		
		List<Person> expectedPerson = new ArrayList<>();
		expectedPerson.add(new Person("Marco", 20));
		expectedPerson.add(new Person("Marcolino", 35));
		
		assertArrayEquals(expectedPerson.toArray(), findedPerson.toArray());
	}
	
	@Test
	public void getPeopleByNameFraPersonManagerTest() throws Exception {
		
		List<Person> findedPerson = pm.getPeopleByName("fra");		
		
		List<Person> expectedPerson = new ArrayList<>();
		expectedPerson.add(new Person("Francesca", 25));
		expectedPerson.add(new Person("Francescana", 40));
		
		assertArrayEquals(expectedPerson.toArray(), findedPerson.toArray());
	}
	
	@Test
	public void getPeopleByNameGianniPersonManagerTest() throws Exception {
		
		List<Person> findedPerson = pm.getPeopleByName("Gianni");	
		
		List<Person> expectedPerson = new ArrayList<>();
		
		assertArrayEquals(expectedPerson.toArray(), findedPerson.toArray());
	}
}
