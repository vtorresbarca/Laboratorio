package com.wirtz.vanesa.negocio.servicios.cita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wirtz.vanesa.persistencia.entidades.Cita;
import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.persistencia.repositorio.cita.CitaRepository;
import com.wirtz.vanesa.utils.Utils;
import com.wirtz.vanesa.vista.dto.user.UserBean;

@Service
public class CitaServiceImpl implements CitaService {

	@Autowired
	CitaRepository citaRepo;
	
	@Override
	public List<Cita> getCitasByUser(UserBean user) {
		return citaRepo.findByUser(Utils.convertBeanToEntity(user));
	}

}
