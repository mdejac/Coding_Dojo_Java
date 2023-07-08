package com.michaeld.productandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.michaeld.productandcategories.services.CategoryService;
import com.michaeld.productandcategories.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("allProducts", productService.getAll());
		model.addAttribute("allCategories", categoryService.getAll());
		return "dashboard.jsp";
	}
}
