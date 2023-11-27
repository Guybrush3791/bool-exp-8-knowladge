package org.java;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {

	private List<Person> people;
	
	public PersonManager() {
		
		people = new ArrayList<>();
	}
	
	public List<Person> getPeople() {
		return people;
	}
	public void setPeople(List<Person> people) {
		this.people = people;
	}

	public void addPerson(String name, int age) throws Exception {
		
		Person p = new Person(name, age);
		people.add(p);
	}
	
	public List<Person> getPeopleByName(String name) {
		
		List<Person> searchedPeople = new ArrayList<>();
		for (Person p : getPeople())
			if (p.getName().toLowerCase().contains(name.toLowerCase()))
				searchedPeople.add(p);
		
		return searchedPeople;
	}
}
