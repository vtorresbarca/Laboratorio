package com.wirtz.vanesa.vista.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wirtz.vanesa.excepciones.ContrasenhasNoCoincidentes;
import com.wirtz.vanesa.negocio.servicios.UserService;
import com.wirtz.vanesa.persistencia.entidades.Usuario;
import com.wirtz.vanesa.vista.dto.UserForm;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/crearUsuario")
	public String crearUsuario(Model model) {
		model.addAttribute("nuevoUsuario", new UserForm());
		return "crearUsuario";
	}
	
	@PostMapping("/crearUsuario")
	public String crearUsuarioNuevo(@Valid@ModelAttribute("nuevoUsuario") UserForm nuevoUsuario, BindingResult result, Model model) {
	
		if(result.hasErrors()) {
			return "crearUsuario";
		}else {
			try {
				userService.crearUsuario(nuevoUsuario);
			} catch (ContrasenhasNoCoincidentes e) {
				model.addAttribute("contrasenhasDiferentes", e);
				return "crearUsuario";
			}
		}
		
		return "index";
	}
}
