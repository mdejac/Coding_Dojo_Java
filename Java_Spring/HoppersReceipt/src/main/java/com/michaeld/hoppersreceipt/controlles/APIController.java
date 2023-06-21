package com.michaeld.hoppersreceipt.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class APIController {
	@RequestMapping("")
	public String index(Model model) {
		String name = "Michael DeJac";
		String itemName = "Yard Soil";
		double price = 279.88;
		String description = "5 Yards of organic top soil";
		String vendor = "Leo Brennans";
		
		model.addAttribute("name", name);
		model.addAttribute("itemName", itemName);
		model.addAttribute("price", price);
		model.addAttribute("description", description);
		model.addAttribute("vendor", vendor);
		
		return "index.jsp";
	}

}
