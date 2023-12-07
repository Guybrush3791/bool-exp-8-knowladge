package org.java.spring.db.pojo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String password;
	private LocalDate signUpDate;
	
	public User() { }
	public User(String username, String password, LocalDate signUpDate) {
		
		setUsername(username);
		setPassword(password);
		setSignUpDate(signUpDate);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getSignUpDate() {
		return signUpDate;
	}
	public void setSignUpDate(LocalDate signUpDate) {
		this.signUpDate = signUpDate;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getUsername() + " - " + getSignUpDate();
	}
}
