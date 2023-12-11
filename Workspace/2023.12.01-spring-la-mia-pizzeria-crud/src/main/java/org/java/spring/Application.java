package org.java.spring;

import java.time.LocalDate;

import org.java.spring.db.pojo.Discount;
import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.DiscountService;
import org.java.spring.db.service.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PizzaServ pizzaServ;
	
	@Autowired
	private DiscountService discountService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza p2 = new Pizza("pizza 2", "desc 2", "https://picsum.photos/300?random=2", 18);
		
		pizzaServ.save(new Pizza("pizza 1", "desc 1", "https://picsum.photos/300?random=1", 5));
		pizzaServ.save(p2);
		pizzaServ.save(new Pizza("calzone 1", "desc 3", "https://picsum.photos/300?random=3", 13));
		pizzaServ.save(new Pizza("calzone 2", "desc 4", "https://picsum.photos/300?random=4", 15));
		pizzaServ.save(new Pizza("pizza 5", "desc 5", "https://picsum.photos/300?random=5", 20));
		
		discountService.save(new Discount(
				LocalDate.now().minusDays(5),
				LocalDate.now().plusDays(10),
				"My Discount",
				p2));
	}
}
