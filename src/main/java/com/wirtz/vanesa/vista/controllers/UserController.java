package com.wirtz.vanesa.vista.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.negocio.servicios.user.UserService;
import com.wirtz.vanesa.vista.dto.user.UserForm;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/createUser")
	public String createUser(Model model) {
		UserForm newUser =  new UserForm();
	    model.addAttribute("isCompany", newUser.getIsCompany());
		model.addAttribute("newUser", new UserForm());
		
		return "crearUsuario";
	}
	 
	@PostMapping("/createUser")
	public String crearUsuarioNuevo(@Valid@ModelAttribute("newUser") UserForm newUser, BindingResult result, Model model) {
	
		if(result.hasErrors()) {
			return "crearUsuario";
		}else {
			try {
				userService.createUser(newUser);
			} catch (DifferentPasswords e) {
				return "crearUsuario";
			}
		}
		
		return "index";
	}
	
	@GetMapping("/listUsers")
	public ModelAndView listUsers() {
		ModelAndView mav = new ModelAndView("clients");
		mav.addObject("clients", userService.listUsers());
		return mav;
	}
}
