package com.wirtz.vanesa.negocio.servicios.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wirtz.vanesa.persistencia.entidades.Company;
import com.wirtz.vanesa.persistencia.repositorio.company.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyRepository companyRepo;
	
	@Override
	public void saveCompany(Company company) {
		companyRepo.save(company);
	}

}
