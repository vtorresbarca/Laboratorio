package com.wirtz.vanesa.negocio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wirtz.vanesa.persistencia.entidades.Center;
import com.wirtz.vanesa.persistencia.entidades.Company;
import com.wirtz.vanesa.persistencia.repositorio.CenterRepository;

public class CenterServiceImpl implements CenterService{

	@Autowired
	CenterRepository centerRepo;
	
	@Override
	public List<Center> findByCompany(Company company) {
		return centerRepo.findByCompany(company);
	}

}
