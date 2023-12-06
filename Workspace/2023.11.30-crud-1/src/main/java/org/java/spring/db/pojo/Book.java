package org.java.spring.db.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60)
	@Length(min = 3, max = 60, message = "Title must be between 3 and 60 characters")
	private String title;
	
	@Column(columnDefinition = "TEXT")
	@Length(min = 3, message = "Author must be longer then 3 characters")
	private String author;
	
	@Column(nullable = false, unique = true)
	@Length(min = 16, max = 16, message = "ISBN must be 16 character long")
	private String isbn;
	
	@DecimalMin(value = "0.0", message = "Il valore deve essere maggiore o uguale a 0.0")
	private double test;
	
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
	public double getTest() {
		return test;
	}
	public void setTest(double test) {
		this.test = test;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getTitle() + " - " 
				+ getAuthor() + " (" + getIsbn() + ")";
	}
}
