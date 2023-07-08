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

import com.michaeld.productandcategories.models.Product;
import com.michaeld.productandcategories.services.CategoryService;
import com.michaeld.productandcategories.services.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "productNew.jsp";
	}
	
	@PostMapping("/new")
	public String newProductSubmit(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "productNew.jsp";
		}
		productService.create(product);
		return "redirect:/";
	}
	
	@GetMapping("/{productId}/view")
	public String viewProduct(@PathVariable("productId") Long id, Model model) {
		Product product = productService.getById(id);
		model.addAttribute("product", product);
		model.addAttribute("allCategories", categoryService.getNotContainingProduct(product));
		return "productView.jsp";
	}
	
	@PostMapping("/{productId}/category")
	public String addCategory(@PathVariable("productId") Long id, @RequestParam("categoryId") Long categoryId) {
		productService.addCategory(categoryId, id);
		return "redirect:/products/"+id+"/view";
	}
}
