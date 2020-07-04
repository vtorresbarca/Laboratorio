package com.wirtz.vanesa.negocio.servicios.cita;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wirtz.vanesa.persistencia.entidades.Cita;
import com.wirtz.vanesa.vista.dto.user.UserBean;

@Service
public interface CitaService {

	public List<Cita> getCitasByUser(UserBean user);
}
