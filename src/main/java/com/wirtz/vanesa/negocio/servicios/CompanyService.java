package com.wirtz.vanesa.negocio.servicios;

import org.springframework.stereotype.Service;

import com.wirtz.vanesa.persistencia.entidades.Company;

@Service
public interface CompanyService {

	public void saveCompany(Company company);
}
