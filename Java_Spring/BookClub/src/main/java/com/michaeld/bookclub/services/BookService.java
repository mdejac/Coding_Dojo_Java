package com.michaeld.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.bookclub.models.Book;
import com.michaeld.bookclub.repositories.BookRepo;

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
	
	public Book update(Book b) {
		return bookRepo.save(b);
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}	
}
