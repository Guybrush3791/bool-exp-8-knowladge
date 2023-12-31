package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.MyObj;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/")
	@ResponseBody
	public String test1() {
		
		return "<h1>Hello, World!</h1><a href=\"test2\">TEST 2</a>";
	}
	
	@GetMapping("/test2")
	public String test2() {
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(Model model) {
		
		// ... data from db
		
		final String username = "Pluto";
		
		model.addAttribute("username", username);
		
		return "test3";
	}
	
	@GetMapping("/test4/{id}")
	public String test4(Model model,
			@PathVariable int id) {
		
		model.addAttribute("id", id);
		
		return "test4";
	}
	
	// http://localhost:8080/test5?nomeutente=marco
	@GetMapping("/test5")
	public String test5(Model model,
			@RequestParam String nomeutente) {
		
		model.addAttribute("nomeutente", nomeutente);
		
		return "test5";
	}
	
	@GetMapping("/test6")
	public String test6(Model model) {
		
		model.addAttribute("myObj", new MyObj(10, "Guybrush")); 
		
		List<MyObj> myObjs = new ArrayList<>();
		myObjs.add(new MyObj(11, "Marco"));
		myObjs.add(new MyObj(12, "Francesca"));
		myObjs.add(new MyObj(13, "Tulio"));
		myObjs.add(new MyObj(14, "Chiara"));
		myObjs.add(new MyObj(15, "Sandra"));
		
		model.addAttribute("myObjs", myObjs);
		
		return "test6";
	}
	
	@GetMapping("/test7")
	public String test7() {
		
		return "test7";
	}
}
