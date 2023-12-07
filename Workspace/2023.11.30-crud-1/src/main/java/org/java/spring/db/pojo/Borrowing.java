package org.java.spring.db.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Borrowing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private LocalDate date;
	
	@ManyToOne
	private Book book;
	
	public Borrowing() { }
	public Borrowing(String name, LocalDate date, Book book) {
		
		setName(name);
		setDate(date);
		setBook(book);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getName() + " - " + getDate();
	}
}
