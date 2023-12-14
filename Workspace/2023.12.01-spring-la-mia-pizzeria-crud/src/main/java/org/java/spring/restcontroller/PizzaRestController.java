package org.java.spring.restcontroller;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1.0/pizzas")
public class PizzaRestController {

	@Autowired
	private PizzaServ pizzaServ;
	
	@GetMapping
	public ResponseEntity<List<Pizza>> getIndex(
			@RequestParam(required = false) String q
		) {
		
		List<Pizza> pizzas = q == null 
							 ? pizzaServ.findAll()
							 : pizzaServ.findByName(q);
		
		return new ResponseEntity<>(pizzas, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pizza> getShow(
			@PathVariable int id
		) {
		
		Pizza pizza = pizzaServ.findById(id);
		
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Pizza> create(
			@RequestBody Pizza pizza
		) {
		
		pizzaServ.save(pizza);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Pizza> update(
			@PathVariable int id,
			@RequestBody Pizza pizzaForm
		) {
		
		Pizza pizza = pizzaServ.findById(id);
		
		pizza.setName(pizzaForm.getName());
		pizza.setDescription(pizzaForm.getDescription());
		pizza.setPhoto(pizzaForm.getPhoto());
		pizza.setPrice(pizzaForm.getPrice());
		
		pizzaServ.save(pizza);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(
			@PathVariable int id
		) {
		
		Pizza pizza = pizzaServ.findById(id);
		pizzaServ.delete(pizza);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
