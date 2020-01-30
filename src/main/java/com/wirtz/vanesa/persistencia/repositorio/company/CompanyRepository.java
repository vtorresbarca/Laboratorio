package com.wirtz.vanesa.persistencia.repositorio.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirtz.vanesa.persistencia.entidades.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{

}
