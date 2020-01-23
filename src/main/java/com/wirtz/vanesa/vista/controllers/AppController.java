package com.wirtz.vanesa.vista.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/admin/soloAdmin")
	public String soloAdmin() {
		return "soloAdmin";
	}
	
	@GetMapping("/user/soloUser")
	public String soloUser() {
		return "soloUser";
	}
}
