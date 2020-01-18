package com.wirtz.vanesa.login.servicios;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/*El UserDetailsService recupera de base de datos la información del usuario 
 * (a través de nuestro UsuarioRepo) que se quiere loguear, creando un objeto de tipo UserDetails*/

public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
