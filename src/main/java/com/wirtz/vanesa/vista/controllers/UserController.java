package com.wirtz.vanesa.vista.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.negocio.servicios.user.UserService;
import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.vista.dto.user.UserForm;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/createUser")
	public String createUser(Model model) {
		UserForm newUser =  new UserForm();
		model.addAttribute("newUser", newUser);
		
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
				result.rejectValue("password", "error.password", "Las contraseñas tienen que ser iguales");
				return "crearUsuario";
			}
		}
		
		return "index";
	}
	
	@PreAuthorize("hasRole('admin')")
	@GetMapping("/listUsers")
	public ModelAndView listUsers() {
		ModelAndView mav = new ModelAndView("clients");
		mav.addObject("clients", userService.listUsers());
		return mav;
	}
	
	@GetMapping("/userProfile")
	public String showProfile(Principal principal, Model model) {
		String username = principal.getName();
		MyUser user = userService.findUserByUsername(username);
		model.addAttribute("user", userService.convertEntityToBean(user));

		return "userProfile";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam(name="username")String username) {
	    MyUser user = userService.findUserByUsername(username);
	  
	    if(user != null) {
	    	userService.deleteUser(user);
	    	userService.expireUserSessions(username);
	    }
	    
	    return "redirect:/";
	}
}
