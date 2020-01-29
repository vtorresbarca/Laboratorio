package com.wirtz.vanesa.persistencia.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirtz.vanesa.persistencia.entidades.MyUser;

/*Nuestro repositorio encargado de los usuarios*/
@Repository
public interface UserRepository extends JpaRepository<MyUser, Long>{
	public Optional<MyUser> findByUsername(String username);
	public Optional<MyUser> findByUsernameAndFirstName(String username, String firstName);
}
