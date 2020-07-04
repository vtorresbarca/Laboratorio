package com.wirtz.vanesa.negocio.servicios.center;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wirtz.vanesa.negocio.servicios.company.CompanyService;
import com.wirtz.vanesa.persistencia.entidades.Center;
import com.wirtz.vanesa.persistencia.entidades.Company;
import com.wirtz.vanesa.persistencia.repositorio.center.CenterRepository;

@Service
public class CenterServiceImpl implements CenterService{

	@Autowired
	CenterRepository centerRepo;
	
	@Autowired
	CompanyService companyService;
	
	@Override
	public List<Center> findByCompany(Company company) {
		return centerRepo.findByCompany(company);
	}

	@Override
	public void saveCenter(Center center) {
		centerRepo.save(center);
	}

	@Override
	public List<Center> initCenters() {
		
		List<Center> centers = new ArrayList<Center>();
		Company company = new Company();
		company.setNif("S0794867B");

		Center c1 = new Center();
		c1.setName("Centro de Valencia");
		c1.setProvince("Valencia");
		c1.setDirection("Rua do Marco, nº 17, Valencia");
		Center c2 = new Center();
		c2.setName("Centro de Madrid");
		c2.setProvince("Madrid");
		Center c3 = new Center();
		c3.setName("Centro de Barcelona");
		c3.setProvince("Barcelona");
		Center c4 = new Center();
		c4.setName("Centro de Málaga");
		c4.setProvince("Malaga");
		c1.setCompany(company);
		c2.setCompany(company);
		c3.setCompany(company);

		centers.add(c1);
		centers.add(c2);
		centers.add(c3);

		company.setCenters(centers);
		
		companyService.saveCompany(company);
		
		for (Center c : centers) {
			centerRepo.save(c);
		}
		
		return centers;
	}

}
