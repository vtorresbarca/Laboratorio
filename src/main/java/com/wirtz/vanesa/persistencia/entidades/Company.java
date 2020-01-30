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
	
	private String username;
	
	private String password;

	@OneToMany(mappedBy="company")
	private List<Center> centers = new ArrayList<Center>();
	
	/*
	 * @OneToMany(mappedBy="companyClient") private Set<MyUser> clients = new
	 * HashSet<MyUser>();
	 * 
	 * Para implementar más adelante: El cliente se crea la cuenta e indica
	 * de que empresa es cliente. Dependiendo de la empresa del cliente mostramos
	 * unos centros u otros. Validar si existe la empresa y tiene ese cliente
	 */
	
	public Company() {
		super();
	}

	public Company(String nif, String name, String username, String password, List<Center> centers) {
		super();
		this.nif = nif;
		this.name = name;
		this.username = username;
		this.password = password;
		this.centers = centers;
		//this.clients = clients;
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

	/*
	 * public Set<MyUser> getClients() { return clients; }
	 * 
	 * public void setClients(Set<MyUser> clients) { this.clients = clients; }
	 */
}
