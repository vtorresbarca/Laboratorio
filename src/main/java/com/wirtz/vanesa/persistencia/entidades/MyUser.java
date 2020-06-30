package com.wirtz.vanesa.persistencia.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/*Clase que representa la tabla de nuestros usuarios en la BD 
 * con sus roles correspondientes*/

@Entity
public class MyUser {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String name;
	
	private String firstName;
	
	private String secondName;
	
	private String email;
	
	private boolean activo;
	
	private boolean isCompany;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="roles_users",
	joinColumns=@JoinColumn(name="id_user"),
	inverseJoinColumns=@JoinColumn(name="id_rol"))
	private Set<Rol> roles = new HashSet<Rol>();

	public MyUser() {
		super();
	}

	public MyUser(Long id, String username, String password, String name, String firstName, String secondName,
			String email, boolean activo, Set<Rol> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.activo = activo;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return activo;
	}

	public void setActive(boolean active) {
		this.activo = active;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isCompany() {
		return isCompany;
	}

	public void setIsCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}
	
}
