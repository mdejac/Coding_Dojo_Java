package com.michaeld.bookbroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class BookBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookBrokerApplication.class, args);
	}
	
	@GetMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/users/login";
		}
		return "dashboard.jsp";
	}


}
