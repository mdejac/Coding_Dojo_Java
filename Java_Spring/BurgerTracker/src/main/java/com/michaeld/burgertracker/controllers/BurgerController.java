package com.michaeld.burgertracker.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.burgertracker.models.Burger;
import com.michaeld.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/burgers")
public class BurgerController {
	
	@Autowired
	BurgerService burgerService;

	@GetMapping("")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {
		ArrayList<Burger> allBurgers = burgerService.allBurgers();
		model.addAttribute("allBurgers", allBurgers);
		return "index.jsp";
	}
	
	@PostMapping("/create/submit")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		
		if (result.hasErrors()) {
			return "index.jsp";
		}
		
		burgerService.create(burger);
		return "redirect:/burgers";
	}
	
	@GetMapping("/{id}")
	public String showBurger(
						@PathVariable("id") Long id,
						Model model) {
		Burger burger = burgerService.findBurger(id);
		model.addAttribute("burger", burger);
		return "showBurger.jsp";
	}
}
