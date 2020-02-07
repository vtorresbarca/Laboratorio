package com.wirtz.vanesa.negocio.servicios.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wirtz.vanesa.excepciones.DifferentPasswordsException;
import com.wirtz.vanesa.excepciones.UsernameAlreadyExistsException;
import com.wirtz.vanesa.vista.dto.user.UserBean;
import com.wirtz.vanesa.vista.dto.user.UserForm;

@Service
public interface UserService {

	void expireUserSessions(String username);
	void createUser(UserForm usuario) throws DifferentPasswordsException, UsernameAlreadyExistsException, WrongPasswordException;
	void deleteByUsername(String username);
	void updateUser(UserForm editUser) throws DifferentPasswordsException,  WrongPasswordException;
	UserBean findUserById(Long id);
	UserBean findUserByUsername(String username);
	List<UserBean> listUsers(); 
}
