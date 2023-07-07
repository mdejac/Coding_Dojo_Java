package com.michaeld.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.bookclub.models.Book;
import com.michaeld.bookclub.services.BookService;
import com.michaeld.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String index(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("allBooks", bookService.getAll());
		model.addAttribute("user", userService.getById((Long) session.getAttribute("userId")));
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("book") Book book, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/users/login";
		}
		return "bookNew.jsp";
	}
	
	@PostMapping("/new")
	public String newBookSubmit(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "bookNew.jsp";
		}
		book.setPostedBy(userService.getById((Long) session.getAttribute("userId")));
		bookService.create(book);
		return "redirect:/books";
	}
	
	@GetMapping("/{bookId}/view")
	public String viewBook(@PathVariable("bookId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/users/login";
		}
		model.addAttribute("book", bookService.getById(id));
		return "bookView.jsp";
	}
	
	@GetMapping("/{bookId}/edit")
	public String newBook(@PathVariable("bookId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/users/login";
		}
		Book book = bookService.getById(id);
		if (!(book.getPostedBy().getId()).equals((Long) session.getAttribute("userId"))) {
			return "redirect:/books";
		}
		model.addAttribute("book", book);
		return "bookEdit.jsp";
	}
	
	@PutMapping("/{id}/edit")
	public String newBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "bookEdit.jsp";
		}
		book.setPostedBy(userService.getById((Long) session.getAttribute("userId")));
		bookService.update(book);
		return "redirect:/books";
	}
	
	@GetMapping("/{bookId}/delete")
	public String deleteBook(@PathVariable("bookId") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/users/login";
		}
		Book book = bookService.getById(id);
		if (!(book.getPostedBy().getId()).equals((Long) session.getAttribute("userId"))) {
			return "redirect:/books";
		}
		bookService.delete(id);
		return "redirect:/books";
	}
}
