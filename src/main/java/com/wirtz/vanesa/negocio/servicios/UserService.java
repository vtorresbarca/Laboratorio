package com.wirtz.vanesa.negocio.servicios;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.persistencia.entidades.Usuario;
import com.wirtz.vanesa.vista.dto.UserForm;

public interface UserService {

	public void createUser(UserForm usuario) throws DifferentPasswords;
	public void borrarUsuario(Long id);
	public void modificarUsuario(Long id, String username, String password);
	public Usuario verDatosUsuario(Long id);
	public Usuario convertirFormToEntity(UserForm user);
}
