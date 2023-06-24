package com.michaeld.omikujiform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class OmikujiFormApplication {

	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}

	public static void main(String[] args) {
		SpringApplication.run(OmikujiFormApplication.class, args);
	}
	

}
