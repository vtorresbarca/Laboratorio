package com.wirtz.vanesa.vista.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wirtz.vanesa.negocio.servicios.cita.CitaService;
import com.wirtz.vanesa.negocio.servicios.user.UserService;
import com.wirtz.vanesa.persistencia.entidades.Cita;
import com.wirtz.vanesa.vista.dto.cita.CitaDto;
import com.wirtz.vanesa.vista.dto.user.UserBean;
import com.wirtz.vanesa.vista.dto.user.UserForm;

@Controller
public class ClientController {

	@Autowired
	CitaService citaService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/citas")
	public String showAppointments(Principal principal, Model model) {
		String username = principal.getName();
		UserBean user = userService.findUserByUsername(username);
		List<Cita> citas = citaService.getCitasByUser(user);
		model.addAttribute("user", user);
		model.addAttribute("citas", citas);
		return "calendar";
	}
	
	@ResponseBody
	@RequestMapping(value = "/citas/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CitaDto>> citas(
			@PathVariable(value = "id") Long idUser) {
		
		List<Cita> citas = citaService.getCitasByUser(userService.findUserById(idUser));
		List<CitaDto> citasDto = new ArrayList<>();
		
		for (Cita cita : citas) {
			CitaDto citaDto = new CitaDto();
			citaDto.setId(cita.getId());
			citaDto.setStart_date(cita.getStart_date());
			citaDto.setEnd_date(cita.getEnd_date());
			citaDto.setText(cita.getText());
			
			citasDto.add(citaDto);
		}
		return new ResponseEntity<List<CitaDto>>(citasDto, HttpStatus.OK);
	}
}
