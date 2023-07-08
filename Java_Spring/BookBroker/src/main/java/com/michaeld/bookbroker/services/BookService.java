package com.michaeld.bookbroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.bookbroker.models.Book;
import com.michaeld.bookbroker.repositories.BookRepo;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;
	
	public Book create(Book b) {
		return bookRepo.save(b);
	}
	
	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	public Book getById(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	public List<Book> getByUserId(Long id) {
		return bookRepo.findByPostedById(id);
	}
	
	public Book update(Book b) {
		return bookRepo.save(b);
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}	
}
