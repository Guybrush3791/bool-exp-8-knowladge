package org.java.spring;

import java.time.LocalDate;

import org.java.spring.db.pojo.User;
import org.java.spring.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		userService.save(new User("guybrush", "code", LocalDate.parse("2023-02-01")));
		userService.save(new User("tulio", "code", LocalDate.parse("2023-02-05")));
		userService.save(new User("marco", "code", LocalDate.parse("2023-02-09")));
		userService.save(new User("franca", "code", LocalDate.parse("2023-02-10")));
		userService.save(new User("giada", "code", LocalDate.parse("2023-02-11")));
	}
}
