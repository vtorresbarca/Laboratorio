package com.wirtz.vanesa.negocio.servicios.rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.persistencia.entidades.Rol;
import com.wirtz.vanesa.persistencia.repositorio.rol.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolRepo;
	
	@Override
	public void saveRol(MyUser user, String rol) {
		Rol newRol = new Rol();
		newRol.setName(rol);
		rolRepo.save(newRol);
		user.getRoles().add(newRol);
	}

}
