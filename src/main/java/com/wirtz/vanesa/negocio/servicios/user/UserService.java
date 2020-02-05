package com.wirtz.vanesa.negocio.servicios.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wirtz.vanesa.excepciones.DifferentPasswords;
import com.wirtz.vanesa.excepciones.UsernameAlreadyExists;
import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.vista.dto.user.UserBean;
import com.wirtz.vanesa.vista.dto.user.UserForm;

@Service
public interface UserService {

	void expireUserSessions(String username);
	void createUser(UserForm usuario) throws DifferentPasswords, UsernameAlreadyExists;
	void deleteByUsername(String username);
	void updateUser(UserForm editUser) throws DifferentPasswords;
	UserBean findUserById(Long id);
	UserBean findUserByUsername(String username);
	List<UserBean> listUsers(); 
	UserBean convertEntityToBean(MyUser userEntity);
	MyUser convertFormToEntity(UserForm user);
}
