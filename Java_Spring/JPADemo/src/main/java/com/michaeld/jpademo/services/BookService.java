package com.michaeld.jpademo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.michaeld.jpademo.models.Book;
import com.michaeld.jpademo.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public ArrayList<Book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // updates a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book tempBook = findBook(id);
    	if (tempBook == null) {
    		return null;
    	}
    	tempBook.setTitle(title);
    	tempBook.setNumberOfPages(numOfPages);
    	tempBook.setLanguage(lang);
    	tempBook.setDescription(desc);
        return bookRepository.save(tempBook);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    //Finds books by description
    public List<Book> findByDescription(String search) {
    	return bookRepository.findByDescriptionContaining(search);
    }
    //Delete a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
