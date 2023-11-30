package org.java.spring.db.serv;

import java.util.List;

import org.java.spring.db.pojo.Book;
import org.java.spring.db.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findAll() {
		
		return bookRepository.findAll();
	}
	public Book findById(int id) {
		
		return bookRepository.findById(id).get();
	}
	public void save(Book book) {
		
		bookRepository.save(book);
	}
}
