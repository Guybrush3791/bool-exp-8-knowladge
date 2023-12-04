package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Book;
import org.java.spring.db.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

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
	
	@GetMapping("/books/create")
	public String createBook(Model model) {
		
		Book book = new Book();
		
		model.addAttribute("book", book);
		
		return "book-form";
	}
	@PostMapping("/books/create")
	public String storeBook(
			Model model,
			@Valid @ModelAttribute Book book, 
			BindingResult bindingResult) {
		
		System.out.println("Book:\n" + book);
		System.out.println("\n---------------\n");
		System.out.println("Error:\n" + bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult);
			model.addAttribute("book", book);
			return "book-form";
		}
		
		try {
			
			bookService.save(book);
		} catch(Exception e) {
			
			bindingResult.addError(new FieldError("book", "isbn", book.getIsbn(), false, null, null, "ISBN must be unique"));
			model.addAttribute("book", book);
			return "book-form";
		}
		
		return "redirect:/";
	}
}
