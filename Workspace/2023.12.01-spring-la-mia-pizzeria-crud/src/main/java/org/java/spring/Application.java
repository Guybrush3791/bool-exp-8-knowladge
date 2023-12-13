package org.java.spring;

import java.time.LocalDate;

import org.java.spring.auth.db.pojo.Role;
import org.java.spring.auth.db.pojo.User;
import org.java.spring.auth.db.service.RoleService;
import org.java.spring.auth.db.service.UserService;
import org.java.spring.db.pojo.Discount;
import org.java.spring.db.pojo.Ingredient;
import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.DiscountService;
import org.java.spring.db.service.IngredientService;
import org.java.spring.db.service.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PizzaServ pizzaServ;
	
	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ingredient ing1 = new Ingredient("pomodoro");
		Ingredient ing2 = new Ingredient("olive");
		Ingredient ing3 = new Ingredient("mozzarella");
		
		ingredientService.save(ing1);
		ingredientService.save(ing2);
		ingredientService.save(ing3);
		
		Pizza p2 = new Pizza("pizza 2", "desc 2", "https://picsum.photos/300?random=2", 18, ing1);
		
		pizzaServ.save(new Pizza("pizza 1", "desc 1", "https://picsum.photos/300?random=1", 5, ing1, ing2));
		pizzaServ.save(p2);
		pizzaServ.save(new Pizza("calzone 1", "desc 3", "https://picsum.photos/300?random=3", 13, ing3));
		pizzaServ.save(new Pizza("calzone 2", "desc 4", "https://picsum.photos/300?random=4", 15, ing1, ing3));
		pizzaServ.save(new Pizza("pizza 5", "desc 5", "https://picsum.photos/300?random=5", 20, ing1, ing2, ing3));
		
		discountService.save(new Discount(
				LocalDate.now().minusDays(5),
				LocalDate.now().plusDays(10),
				"My Discount",
				p2));
		
		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");
		
		roleService.save(roleUser);
		roleService.save(roleAdmin);
		
		String pws = passwordEncoder.encode("pws");
		
		User guybrushUser = new User("guybrushUser", pws, roleUser);
		User guybrushAdmin = new User("guybrushAdmin", pws, roleAdmin);
		
		userService.save(guybrushUser);
		userService.save(guybrushAdmin);
	}
}
