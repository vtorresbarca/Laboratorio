package com.wirtz.vanesa.login.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Clase que representa la tabla de nuestros usuarios en la BD 
 * con sus roles correspondientes*/

@Entity
public class EntidadUsuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nombreUsuario;
	
	private String contrasenha;
	
	private boolean activo;
	
	private Set<Rol> roles;

	
	public EntidadUsuario() {
		super();
	}

	public EntidadUsuario(Long id, String nombreUsuario, String contrasenha, boolean activo, Set<Rol> roles) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.contrasenha = contrasenha;
		this.activo = activo;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
}
