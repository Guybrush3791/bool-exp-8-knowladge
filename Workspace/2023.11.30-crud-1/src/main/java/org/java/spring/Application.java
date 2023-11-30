package org.java.spring;

import org.java.spring.db.pojo.Book;
import org.java.spring.db.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		bookService.save(new Book("My Best Java Book 1", "Guybrush", "123423423"));
		bookService.save(new Book("My Best Java Book 2", "Guybrush", "123423424"));
		bookService.save(new Book("My Best Java Book 3", "Guybrush", "123423425"));
		bookService.save(new Book("My Best Java Book 4", "Guybrush", "123423426"));
		bookService.save(new Book("My Best Java Book 5", "Guybrush", "123423427"));
		bookService.save(new Book("My Best Java Book 6", "Guybrush", "123423428"));
		bookService.save(new Book("My Best Java Book 7", "Guybrush", "123423429"));
	}
}
