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
import com.wirtz.vanesa.excepciones.EditPasswordEmpty;
import com.wirtz.vanesa.excepciones.EditUsernameEmpty;
import com.wirtz.vanesa.excepciones.UsernameAlreadyExists;
import com.wirtz.vanesa.negocio.servicios.user.UserService;
import com.wirtz.vanesa.vista.dto.user.UserBean;
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
				
			} catch (UsernameAlreadyExists u) {
				result.rejectValue("username", "error.username", "Ese nombre de usuario ya existe, introduzca otro");
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
		UserBean user = userService.findUserByUsername(username);
		model.addAttribute("user", user);

		return "userProfile";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@RequestParam(name="username")String username) {

	    if(!username.isEmpty()) {
	    	userService.deleteByUsername(username);
	    	userService.expireUserSessions(username);
	    }
	    
	    return "redirect:/";
	}
	
	@GetMapping("/editUser")
	public String editUser(Principal principal, Model model) {
		String username = principal.getName();
		UserBean user = userService.findUserByUsername(username);
		model.addAttribute("user", user);
		
		return "editUserProfile";
	}
	
	@PostMapping("/editUser")
	public String editUser(@Valid@ModelAttribute("user") UserForm editUser, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editUserProfile";
		}else {
			try {
				
				userService.updateUser(editUser);
			}catch (DifferentPasswords ex) {
				//result.rejectValue("password", "error.password", "Las contraseñas tienen que ser iguales");
				return "editUserProfile";
			}catch (EditUsernameEmpty e) {
				result.rejectValue("username", "error.username", "El nombre de usuario no puede estar vacío");
				return "editUserProfile";
			}catch (EditPasswordEmpty p) {
				result.rejectValue("password", "error.password", "El campo 'contraseña' no puede estar vacío");
				return "editUserProfile";
			}
		}
		return "userProfile";
	}
}
