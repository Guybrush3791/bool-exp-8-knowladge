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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private PizzaServ pizzaServ;
	
	@GetMapping("/ingredients")
	public String getIngredients(Model model) {
		
		List<Ingredient> ingredients = ingredientService.findAll();
		
		model.addAttribute("ingredients", ingredients);
		
		return "ingredients";
	}
	@GetMapping("/ingredient/create")
	public String createIngredient(Model model) {
		
		model.addAttribute("ingredient", new Ingredient());
		
		return "ingredient-form";
	}
	@PostMapping("/ingredient/create")
	public String storeIngredient(
			Model model,
			@Valid @ModelAttribute Ingredient ingredient,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			
			model.addAttribute("ingredient", ingredient);
			
			return "ingredient-form";
		}
		
		ingredientService.save(ingredient);
		
		return "redirect:/ingredients";
	}
	
	@PostMapping("/ingredient/delete/{id}")
	public String deleteIngredient(@PathVariable int id) {
		
		Ingredient ingredient = ingredientService.findById(id);
		
		List<Pizza> ingPizzas = ingredient.getPizzas();
		ingPizzas.forEach(p -> {
			
			p.getIngredients().remove(ingredient);
			pizzaServ.save(p);
		});
		
		ingredientService.delete(ingredient);
		
		return "redirect:/ingredients";
	}
}
