package org.java.spring;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PizzaServ pizzaServ;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		pizzaServ.save(new Pizza("pizza 1", "desc 1", "https://picsum.photos/300?random=1", 5));
		pizzaServ.save(new Pizza("pizza 2", "desc 2", "https://picsum.photos/300?random=2", 18));
		pizzaServ.save(new Pizza("calzone 1", "desc 3", "https://picsum.photos/300?random=3", 13));
		pizzaServ.save(new Pizza("calzone 2", "desc 4", "https://picsum.photos/300?random=4", 15));
		pizzaServ.save(new Pizza("pizza 5", "desc 5", "https://picsum.photos/300?random=5", 20));
	}
}
