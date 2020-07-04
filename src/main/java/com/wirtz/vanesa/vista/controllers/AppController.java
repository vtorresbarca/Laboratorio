package com.wirtz.vanesa.vista.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wirtz.vanesa.negocio.servicios.center.CenterService;
import com.wirtz.vanesa.negocio.servicios.company.CompanyService;
import com.wirtz.vanesa.negocio.servicios.user.UserService;
import com.wirtz.vanesa.vista.dto.user.UserBean;

@Controller
public class AppController {

	@Autowired
	CenterService centerService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	UserService userService;
	
	@GetMapping({ "/" })
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/centerList")
	public ModelAndView centerList() {
		ModelAndView mav = new ModelAndView("centers");
		mav.addObject("centers", centerService.initCenters());

		return mav;
	}
}
