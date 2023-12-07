package org.java.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.java.spring.db.pojo.Book;
import org.java.spring.db.pojo.Borrowing;
import org.java.spring.db.serv.BookService;
import org.java.spring.db.serv.BorrowingService;
import org.java.spring.dto.BookBorrowingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BorrowingController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BorrowingService borrowingService;
	
	@GetMapping("/books/borrow")
	public String getBorrowingForm(Model model) {
		
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		
		return "borrow-form";
	}
	@PostMapping("/books/borrow")
	public String storeBorrowing(
			@ModelAttribute BookBorrowingDTO bookBorrowingDTO
		) {
		
		Book book = bookService.findById(bookBorrowingDTO.getBook_id());
		
		Borrowing borrowing = new Borrowing(
				bookBorrowingDTO.getName(),
				LocalDate.now(),
				book);
		
		borrowingService.save(borrowing);
		
		return "redirect:/";
	}
}
