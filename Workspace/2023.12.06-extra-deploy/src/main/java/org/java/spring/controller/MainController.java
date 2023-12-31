package org.java.spring.controller;

import org.java.spring.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getHelloWorld(Model model) {
		
		model.addAttribute("users", userService.findAll());
		
		return "hello";
	}
}
