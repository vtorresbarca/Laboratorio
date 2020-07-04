package com.wirtz.vanesa.persistencia.repositorio.cita;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirtz.vanesa.persistencia.entidades.Cita;
import com.wirtz.vanesa.persistencia.entidades.MyUser;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
	
	public List<Cita> findByUser(MyUser user);
}
