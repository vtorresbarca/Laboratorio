package com.wirtz.vanesa.negocio.servicios.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.vista.dto.user.UserForm;

@Service
public interface UserService {

	public void createUser(UserForm usuario) throws DifferentPasswords;
	public void deleteUser(Long id);
	public void updateUser(Long id, String username, String password);
	public MyUser readUser(Long id);
	public MyUser convertirFormToEntity(UserForm user);
	public List<MyUser> listUsers(); //TODO: esto tiene que devolver un UserBean
}
