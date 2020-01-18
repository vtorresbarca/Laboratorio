package com.wirtz.vanesa.login.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirtz.vanesa.login.entidades.EntidadUsuario;

/*Nuestro repositorio encargado de los usuarios*/
@Repository
public interface UsuarioRepo extends JpaRepository<EntidadUsuario, Long>{
	public Optional<EntidadUsuario> findByUsername(String username);
}
