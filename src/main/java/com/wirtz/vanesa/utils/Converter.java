package com.wirtz.vanesa.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wirtz.vanesa.persistencia.entidades.MyUser;
import com.wirtz.vanesa.vista.dto.user.UserBean;
import com.wirtz.vanesa.vista.dto.user.UserEditForm;
import com.wirtz.vanesa.vista.dto.user.UserForm;

public class Converter {

	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	
	public static MyUser convertFormToEntity(UserForm user) {
		MyUser miUsuario = new MyUser();
		miUsuario.setId(user.getId());
		miUsuario.setUsername(user.getUsername());
		miUsuario.setPassword(encoder.encode(user.getPassword()));
		miUsuario.setName(user.getName());
		miUsuario.setFirstName(user.getFirstName());
		miUsuario.setSecondName(user.getSecondName());
		miUsuario.setEmail(user.getEmail());
		
		return miUsuario;
	}

	public static UserBean convertEntityToBean(MyUser userEntity) {
		return new UserBean(userEntity.getId(), userEntity.getUsername(), userEntity.getName(), userEntity.getFirstName(),
				userEntity.getSecondName(), userEntity.getEmail(), userEntity.getPassword());
	}
	
	public static MyUser convertEditFormToEntity(UserEditForm user) {
		MyUser miUsuario = new MyUser();
		miUsuario.setUsername(user.getUsername());
		miUsuario.setPassword(encoder.encode(user.getPassword()));
		miUsuario.setName(user.getName());
		miUsuario.setFirstName(user.getFirstName());
		miUsuario.setSecondName(user.getSecondName());
		miUsuario.setEmail(user.getEmail());
		return miUsuario;
	}
}
