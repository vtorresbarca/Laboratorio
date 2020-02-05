package com.wirtz.vanesa.negocio.servicios.rol;

import org.springframework.stereotype.Service;

import com.wirtz.vanesa.persistencia.entidades.MyUser;

@Service
public interface RolService {

	void createRol(MyUser user, String rol);
}
