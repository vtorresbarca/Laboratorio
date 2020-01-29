package com.wirtz.vanesa.persistencia.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
	@Id
	private String nif;
	
	private String name;
	
	private String sector;
	
	private String username;
	
	private String password;

	@OneToMany(mappedBy="company")
	private List<Center> centers = new ArrayList<Center>();
	
	public Company() {
		super();
	}

	public Company(String cif, String name, String sector, String username, 
			String password, List<Center> centers) {
		super();
		this.nif = cif;
		this.name = name;
		this.sector = sector;
		this.username = username;
		this.password = password;
		this.centers = centers;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Center> getCenters() {
		return centers;
	}

	public void setCenters(List<Center> centers) {
		this.centers = centers;
	}

}
