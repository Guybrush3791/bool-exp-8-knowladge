package org.java.spring.db.serv;

import java.util.List;

import org.java.spring.db.pojo.Category;
import org.java.spring.db.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> findAll() {
		
		return categoryRepo.findAll();
	}
	public Category findById(int id) {
		
		return categoryRepo.findById(id).get();
	}
	public void save(Category category) {
		
		categoryRepo.save(category);
	}
}
