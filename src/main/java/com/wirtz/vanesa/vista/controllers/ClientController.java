package com.wirtz.vanesa.vista.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wirtz.vanesa.negocio.servicios.CenterService;
import com.wirtz.vanesa.negocio.servicios.CompanyService;

@Controller
public class ClientController {

	//https://ejemplos.net/ejemplos-de-cif-empresa/
	
	@Autowired
	CenterService centerService;
	
	@Autowired
	CompanyService companyService;
	
	@GetMapping("/centerList")
	public ModelAndView centerList() {
		ModelAndView mav = new ModelAndView("centers");

		
		return mav;
	}
}
