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
	
	private String direction;
	
	private String province;
	
	@ManyToOne
	private Company company;
	
	public Center() {
		
	}

	public Center(Long idCenter, String direction, String province, Company company) {
		super();
		this.idCenter = idCenter;
		this.direction = direction;
		this.province = province;
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
	
}
