package com.michaeld.burgertracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class BurgerTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerTrackerApplication.class, args);
	}
	
	@RequestMapping("/")
	public String reroute() {
		return "redirect:/burgers";
	}

}
