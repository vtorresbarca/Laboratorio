package com.wirtz.vanesa.negocio.servicios;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.vista.dto.UserForm;

public interface UserService {

	public void createUser(UserForm usuario) throws DifferentPasswords;
	public void deleteUser(Long id);
	public void updateUser(Long id, String username, String password);
	public MyUser readUser(Long id);
	public MyUser convertirFormToEntity(UserForm user);
}
