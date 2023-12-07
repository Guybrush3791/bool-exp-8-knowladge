package org.java.spring.dto;

public class BookBorrowingDTO {

	private int book_id;
	private String name;
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		return getBook_id() + " - " + getName();
	}
}
