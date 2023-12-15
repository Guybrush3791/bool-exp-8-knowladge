package org.java.spring.db.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PizzaServ {

	@Autowired
	private PizzaRepo pizzaRepo;
	
	@Transactional
	public List<Pizza> findAll() {
		
		List<Pizza> pizzas = pizzaRepo.findAll();
		
		pizzas.forEach(p -> Hibernate.initialize(p.getIngredients()));		
		return pizzas;
	}
	public Pizza findById(int id) {
		
		return pizzaRepo.findById(id).get();
	}
	public List<Pizza> findByName(String name) {
		
		return pizzaRepo.findByNameContainingIgnoreCase(name);
	}
	public void save(Pizza pizza) {
		
		pizzaRepo.save(pizza);
	}
	public void delete(Pizza pizza) {
		
		pizzaRepo.delete(pizza);
	}
}
