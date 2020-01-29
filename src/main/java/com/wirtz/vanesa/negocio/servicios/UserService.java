package com.wirtz.vanesa.negocio.servicios;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.vista.dto.UserForm;

public interface UserService {

	public void createUser(UserForm usuario) throws DifferentPasswords;
	public void borrarUsuario(Long id);
	public void modificarUsuario(Long id, String username, String password);
	public MyUser verDatosUsuario(Long id);
	public MyUser convertirFormToEntity(UserForm user);
}
