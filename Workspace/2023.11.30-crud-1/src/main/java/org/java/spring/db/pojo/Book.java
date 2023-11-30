package org.java.spring.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String author;
	
	@Column(nullable = false, unique = true)
	private String isbn;
	
	public Book() { }
	public Book(String title, String author, String isbn) {
		
		setTitle(title);
		setAuthor(author);
		setIsbn(isbn);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getTitle() + " - " 
				+ getAuthor() + " (" + getIsbn() + ")";
	}
}
