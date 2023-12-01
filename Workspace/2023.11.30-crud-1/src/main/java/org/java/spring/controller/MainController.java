package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Book;
import org.java.spring.db.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public String getBooks(Model model,
			@RequestParam(required = false) String q) {
		
		List<Book> books = q == null  
					? bookService.findAll()
					: bookService.findByTitleOrAuthor(q);
		
		model.addAttribute("books", books);
		model.addAttribute("q", q == null ? "" : q);
		
		return "books";
	}
	
	@GetMapping("/books/{id}")
	public String getBook(Model model,
			@PathVariable int id) {
		
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		
		return "book";
	}
}
