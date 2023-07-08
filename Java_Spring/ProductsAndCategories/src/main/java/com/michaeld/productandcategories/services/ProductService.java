package com.michaeld.productandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.productandcategories.models.Category;
import com.michaeld.productandcategories.models.Product;
import com.michaeld.productandcategories.repositories.CategoryRepo;
import com.michaeld.productandcategories.repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	public Product create(Product p) {
		return productRepo.save(p);
	}
	
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
	public Product getById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public List<Product> getNotContainingCategory(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public Product update(Product p) {
		return productRepo.save(p);
	}
	
	public void addCategory(Long categoryId, Long productId) {
		Category category = findCategoryById(categoryId);
		Product product = findProductById(productId);
		product.getCategories().add(category);
		productRepo.save(product);
	}
	
	public void delete(Long id) {
		productRepo.deleteById(id);
	}
	
	public Category findCategoryById(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public Product findProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
}
