package com.michaeld.productandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michaeld.productandcategories.models.Category;
import com.michaeld.productandcategories.services.CategoryService;
import com.michaeld.productandcategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "categoryNew.jsp";
	}
	
	@PostMapping("/new")
	public String newCategorySubmit(@Valid @ModelAttribute("categor") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "categoryNew.jsp";
		}
		categoryService.create(category);
		return "redirect:/";
	}
	
	@GetMapping("/{categoryId}/view")
	public String viewProduct(@PathVariable("categoryId") Long id, Model model) {
		Category category = categoryService.getById(id);
		System.out.println("id " + id);
		System.out.println("category name " + category.getName());
		model.addAttribute("category", category);
		model.addAttribute("allProducts", productService.getNotContainingCategory(category));
		return "categoryView.jsp";
	}
	
	@PostMapping("/{categoryId}/product")
	public String addCategory(@PathVariable("categoryId") Long id, @RequestParam("productId") Long productId) {
		productService.addCategory(id, productId);
		return "redirect:/categories/"+id+"/view";
	}
}
