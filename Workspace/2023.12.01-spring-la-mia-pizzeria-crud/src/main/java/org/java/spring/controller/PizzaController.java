package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Ingredient;
import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.service.IngredientService;
import org.java.spring.db.service.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class PizzaController {

	@Autowired
	private PizzaServ pizzaServ;
	
	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping
	public String getPizzas(Model model,
			@RequestParam(name = "q", required = false) String query) {
		
		System.out.println("redirectAttributes: " + model.getAttribute("deletedPizza"));
		
		List<Pizza> pizzas = query == null 
							 ? pizzaServ.findAll()
							 : pizzaServ.findByName(query);
		
		model.addAttribute("query", query);
		model.addAttribute("pizzas", pizzas);
		
		return "pizzas";
	}
	
	@GetMapping("/pizzas/{id}")
	public String getPizza(Model model,
			@PathVariable int id) {
		
		Pizza pizza = pizzaServ.findById(id);
		
		model.addAttribute("pizza", pizza);
		
		return "pizza";
	}
	
	@GetMapping("/pizza/create")
	public String createPizza(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		
		List<Ingredient> ingredients = ingredientService.findAll();
		model.addAttribute("ingredients", ingredients);
		
		return "pizza-form";
	}
	@PostMapping("/pizza/create")
	public String storePizza(Model model,
			@Valid @ModelAttribute Pizza pizza,
			BindingResult bindingResult) {
		
		return savePizza(model, pizza, bindingResult);
	}
	
	@GetMapping("/pizza/edit/{id}")
	public String editPizza(Model model, @PathVariable int id) {
		
		Pizza pizza = pizzaServ.findById(id);
		model.addAttribute("pizza", pizza);
		
		List<Ingredient> ingredients = ingredientService.findAll();
		model.addAttribute("ingredients", ingredients);
				
		return "pizza-form";
	}
	@PostMapping("/pizza/edit/{id}")
	public String updatePizza(Model model,
			@Valid @ModelAttribute Pizza pizza,
			BindingResult bindingResult) {
		
		return savePizza(model, pizza, bindingResult);
	}
	
	@PostMapping("/pizza/delete/{id}")
	public String deletePizza(@PathVariable int id, RedirectAttributes redirectAttributes) {
		
		Pizza pizza = pizzaServ.findById(id);
		pizzaServ.delete(pizza);
		
		redirectAttributes.addFlashAttribute("deletedPizza", pizza);
		
		return "redirect:/";
	}
	
	private String savePizza(Model model,
			@Valid @ModelAttribute Pizza pizza,
			BindingResult bindingResult) {
		
		System.out.println(pizza);
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("pizza", pizza);
			
			return "pizza-form";
		}
		
		try {
		
			pizzaServ.save(pizza);
		} catch(Exception e) {
			
			model.addAttribute("pizza", pizza);
			return "pizza-form";
		}
		
		
		return "redirect:/";
	}
}
