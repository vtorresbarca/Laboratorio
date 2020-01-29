package com.wirtz.vanesa.persistencia.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirtz.vanesa.persistencia.entidades.Usuario;

/*Nuestro repositorio encargado de los usuarios*/
@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{
	public Optional<Usuario> findByUsername(String username);
	public Optional<Usuario> findByUsernameAndFirstName(String username, String firstName);
}
