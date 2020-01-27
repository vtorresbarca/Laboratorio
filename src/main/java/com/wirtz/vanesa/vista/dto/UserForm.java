package com.wirtz.vanesa.vista.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserForm {

	private Long id;
	
	@NotNull(message="El nombre de usuario es obligatorio")
	@NotBlank(message="El nombre de usuario no puede estar en blanco")
	private String nombreUsuario;
	
	private String contrasenha;
	
	private String contrasenha2;

	private String nombre;
	
	private String apellido1;
	
	private String apellido2;


	public UserForm() {
	}
	
	public UserForm(Long id, String username, String contrasenha, String contrasenha2) {
		super();
		this.id = id;
		this.nombreUsuario = username;
		this.contrasenha = contrasenha;
		this.contrasenha2 = contrasenha2;
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

	public String getContrasenha2() {
		return contrasenha2;
	}

	public void setContrasenha2(String contrasenha2) {
		this.contrasenha2 = contrasenha2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

}
