package org.java.spring.db.service;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaServ {

	@Autowired
	private PizzaRepo pizzaRepo;
	
	public List<Pizza> findAll() {
		
		return pizzaRepo.findAll();
	}
	public Pizza findById(int id) {
		
		return pizzaRepo.findById(id).get();
	}
	public void save(Pizza pizza) {
		
		pizzaRepo.save(pizza);
	}
}
