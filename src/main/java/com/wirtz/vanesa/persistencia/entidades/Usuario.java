package com.wirtz.vanesa.persistencia.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import ch.qos.logback.core.subst.Token.Type;

import javax.persistence.JoinColumn;

/*Clase que representa la tabla de nuestros usuarios en la BD 
 * con sus roles correspondientes*/

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private String contrasenha;
	
	private boolean activo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="roles_usuarios",
	joinColumns=@JoinColumn(name="id_usuario"),
	inverseJoinColumns=@JoinColumn(name="id_rol"))
	private Set<Rol> roles;

	
	public Usuario() {
		super();
		roles = new HashSet<Rol>();
	}

	public Usuario(Long id, String nombreUsuario, String contrasenha, boolean activo) {
		super();
		this.id = id;
		this.username = nombreUsuario;
		this.contrasenha = contrasenha;
		this.activo = activo;
		roles = new HashSet<Rol>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return username;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.username = nombreUsuario;
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
