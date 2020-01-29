package com.wirtz.vanesa.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirtz.vanesa.persistencia.entidades.Center;
import com.wirtz.vanesa.persistencia.entidades.Company;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long>{
	
	List<Center> findByCompany(Company company);
}
