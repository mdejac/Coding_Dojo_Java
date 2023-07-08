package com.michaeld.productandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.productandcategories.models.Category;
import com.michaeld.productandcategories.models.Product;
import com.michaeld.productandcategories.repositories.CategoryRepo;
import com.michaeld.productandcategories.repositories.ProductRepo;

@Service
public class CategoryService {
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	public Category create(Category c) {
		return categoryRepo.save(c);
	}
	
	public List<Category> getAll() {
		return categoryRepo.findAll();
	}
	
	public Category getById(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public List<Category> getByProduct(Product product) {
		return categoryRepo.findAllByProducts(product);
	}
	
	public List<Category> getNotContainingProduct(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public Category update(Category c) {
		return categoryRepo.save(c);
	}
	
	public void addProduct(Long categoryId, Long productId) {
		Category category = findCategoryById(categoryId);
		Product product = findProductById(productId);
		category.getProducts().add(product);
		categoryRepo.save(category);
	}
	
	public void delete(Long id) {
		categoryRepo.deleteById(id);
	}
	
	public Category findCategoryById(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	public Product findProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
}
