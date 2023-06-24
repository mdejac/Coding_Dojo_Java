package com.michaeld.ninjagold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class NinjaGoldApplication {

	@GetMapping("/")
	public String reroute() {
		return "redirect:/ninjaGold";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NinjaGoldApplication.class, args);
	}

}
