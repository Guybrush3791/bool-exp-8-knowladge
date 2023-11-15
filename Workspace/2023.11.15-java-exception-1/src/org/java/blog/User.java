package org.java.blog;

import org.java.blog.exception.PasswordException;

public class User {

	private String username;
	private String password;
	
	public User(String username, String password) throws Exception {
		
		setUsername(username);
		setPassword(password);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) throws Exception {
		
		if (username == null || username.isEmpty() || username.length() <= 3) 
			throw new Exception("username must be longer then 3 characters");
		
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws PasswordException {
		
		if (password == null || password.isEmpty() || password.length() <= 3)
			throw new PasswordException("password must be longer then 3 characters");
		
//		boolean finded = false;
//		for (int x=0;x<password.length();x++) {
//			
//			if (/*i-esimo carattere e' un numero*/)
//				finded = true;
//		}
//		
//		if (!finded) {
//			throw new PasswordException("password must be longer then 3 characters");
//		}
		
		this.password = password;
	}
	
	@Override
	public String toString() {
		
		return getUsername();
	}
}
