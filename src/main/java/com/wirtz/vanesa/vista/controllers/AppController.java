package com.wirtz.vanesa.vista.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping({ "/" })
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/tutorial")
	public String tutorial() {
		return "tutorialAutorizaciones";
	}
}
