package com.wirtz.vanesa.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirtz.vanesa.persistencia.entidades.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {



}
