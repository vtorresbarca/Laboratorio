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
	
}
