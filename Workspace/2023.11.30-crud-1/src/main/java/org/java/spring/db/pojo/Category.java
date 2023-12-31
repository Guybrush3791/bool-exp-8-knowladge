package org.java.spring.db.pojo;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private List<Book> books;
	
	public Category() { }
	public Category(String name, String description, Book... books) {
		
		setName(name);
		setDescription(description);
		setBooks(books);
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public void setBooks(Book[] books) {
		setBooks(Arrays.asList(books));
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getName() + ": " + getDescription();
	}
}
