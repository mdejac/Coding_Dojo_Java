package com.michaeld.jpademo.controllers;

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

import com.michaeld.jpademo.models.Book;
import com.michaeld.jpademo.services.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("")
	public String index(Model model) {
		ArrayList<Book> allBooks = bookService.allBooks();
		model.addAttribute("allBooks", allBooks);
		return "index.jsp";
	}
	
	@GetMapping("/{id}")
	public String showBook(
						@PathVariable("id") Long id,
						Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "showBook.jsp";
	}
	
	@GetMapping("/create")
	public String createBook(@ModelAttribute("book") Book book) {
		return "create.jsp";
	}
	
	@PostMapping("/create/submit")
	public String handleCreateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		
		if(result.hasErrors()) {
			return "create.jsp";
		}
		
		bookService.createBook(book);
		return "redirect:/books";
	}
	
//	@PostMapping("/create/submit")
//	public String handleCreateBook(
//		    			@RequestParam("title") String title,
//		    			@RequestParam("description") String description,
//		    			@RequestParam("language") String language,
//		    			@RequestParam("numberOfPages") Integer pages) {
//		    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
//		    Book book = new Book(title, description, language, pages);
//		    bookService.createBook(book);
//		return "redirect:/books";
//	}
}
