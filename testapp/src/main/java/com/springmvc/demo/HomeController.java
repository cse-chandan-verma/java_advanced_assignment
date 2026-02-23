package com.springmvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@RequestMapping("/home")	
	public String home(Model model) {
		User user = new User(101, "Chandan", "Punjab");
		model.addAttribute("user", user);
		return "home";
	}
	
	@RequestMapping("/login")	
	public String login() {
		return "login";
	}
	
	
}
