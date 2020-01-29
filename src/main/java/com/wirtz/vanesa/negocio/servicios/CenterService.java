package com.wirtz.vanesa.negocio.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wirtz.vanesa.persistencia.entidades.Center;
import com.wirtz.vanesa.persistencia.entidades.Company;

@Service
public interface CenterService {

	List<Center> findByCompany(Company company);
}
