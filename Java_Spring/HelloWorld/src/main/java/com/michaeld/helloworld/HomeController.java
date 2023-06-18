package com.michaeld.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "Hello World!!";
	}
	
	@RequestMapping("/message")
	public String myMessage() {
		return "This is my message!";
	}
}
