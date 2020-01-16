package com.wirtz.vanesa.persistencia.users.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wirtz.vanesa.persistence.users.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity>findByUsername(String username); //si recibimos o no el user poder comprobarlo
}
