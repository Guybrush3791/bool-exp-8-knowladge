package org.java.spring.db.service;

import java.util.List;

import org.java.spring.db.pojo.User;
import org.java.spring.db.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public List<User> findAll() {
		
		return userRepo.findAll();
	}
	public User findById(int id) {
		
		return userRepo.findById(id).get();
	}
	public void save(User user) {
		
		userRepo.save(user);
	}
}
