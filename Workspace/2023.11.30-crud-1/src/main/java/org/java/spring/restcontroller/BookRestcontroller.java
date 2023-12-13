package org.java.spring.restcontroller;

import java.util.List;
import java.util.Optional;

import org.java.spring.db.pojo.Book;
import org.java.spring.db.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/books")
public class BookRestcontroller {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getIndex() {
		
		List<Book> books = bookService.findAll();
		
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Book> getBook(@PathVariable int id) {
		
		Optional<Book> bookOpt = bookService.findById(id);
		if (bookOpt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Book book = bookOpt.get();
		
		if (book == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Book> create(@RequestBody Book book) {
		
		bookService.save(book);
		
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Book> update(
			@PathVariable int id,
			@RequestBody Book newBook) {
	
		Optional<Book> bookOpt = bookService.findById(id);
		if (bookOpt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Book book = bookOpt.get();
		
		book.setTitle(newBook.getTitle());
		book.setAuthor(newBook.getAuthor());
		book.setIsbn(newBook.getIsbn());
		
		bookService.save(book);
		
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Book> delete(
			@PathVariable int id) {
		
		Optional<Book> bookOpt = bookService.findById(id);
		if (bookOpt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Book book = bookOpt.get();
		
		if (book == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		bookService.delete(book);
		
		return new ResponseEntity<>(book, HttpStatus.OK); 
	}
}
