package com.wirtz.vanesa.negocio.servicios.company;

import org.springframework.stereotype.Service;

import com.wirtz.vanesa.persistencia.entidades.Company;

@Service
public interface CompanyService {

	public Company getCompany();
	public void saveCompany(Company company);
}
