package com.wirtz.vanesa.persistencia.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Center {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCenter;
	
	private String name;
	
	private String direction;
	
	private String province;
	
	private Long telephone;
	
	@ManyToOne
	private Company company;
	
	public Center() {
		
	}

	public Center(Long idCenter, String name, String direction, String province, Long telefone, Company company) {
		super();
		this.idCenter = idCenter;
		this.name = name;
		this.direction = direction;
		this.province = province;
		this.telephone = telefone;
		this.company = company;
	}

	public Long getIdCenter() {
		return idCenter;
	}

	public void setIdCenter(Long idCenter) {
		this.idCenter = idCenter;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

}
