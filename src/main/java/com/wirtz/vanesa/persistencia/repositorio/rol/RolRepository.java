package com.wirtz.vanesa.persistencia.repositorio.rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirtz.vanesa.persistencia.entidades.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {



}
