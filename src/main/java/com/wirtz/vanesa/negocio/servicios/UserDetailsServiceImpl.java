package com.wirtz.vanesa.negocio.servicios;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wirtz.vanesa.persistencia.entidades.Rol;
import com.wirtz.vanesa.persistencia.entidades.Usuario;
import com.wirtz.vanesa.persistencia.repositorio.UserRepository;

/*El UserDetailsService recupera de base de datos la información del usuario 
 * (a través de nuestro UsuarioRepo) que se quiere loguear, creando un objeto de tipo UserDetails*/

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository usuarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//Buscamos el usuario con findByUsername
		Usuario usuarioBuscado = usuarioRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		
		//Creamos la lista de los roles/accessos que tiene el usuario
		Set<GrantedAuthority>listaRoles = new HashSet<GrantedAuthority>(); 

	    for (Rol rol: usuarioBuscado.getRoles()) {
	        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getName());
	            listaRoles.add(grantedAuthority);
	    }
	    
	    /*Creamos un objeto UserDetails para retornarlo
	    (es el que necesita Spring Security para trabajar)*/
	    UserDetails usuarioFinal = (UserDetails) new User(
	    							usuarioBuscado.getNombreUsuario(),
	    							usuarioBuscado.getContrasenha(),
	    							listaRoles);
	   
		return usuarioFinal;
	}

}
