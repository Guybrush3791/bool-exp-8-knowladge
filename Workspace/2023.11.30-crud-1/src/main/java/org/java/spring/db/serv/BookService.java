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
	public List<Book> findByTitleOrAuthor(String query) {
		
		return bookRepository.findByTitleContainingOrAuthorContainingIgnoreCase(query, query);
	}
	public void save(Book book) {
		
		bookRepository.save(book);
	}
	public void delete(Book book) {
		
		bookRepository.delete(book);
	}
	public void deleteById(int id) {
		
		bookRepository.deleteById(id);
	}
}
