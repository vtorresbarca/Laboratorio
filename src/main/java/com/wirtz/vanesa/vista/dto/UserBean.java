package com.wirtz.vanesa.vista.dto;

public class UserBean {

	private String username;
	
	private String contrasenha;
	
	
	public UserBean(String username, String contrasenha) {
		super();
		this.username = username;
		this.contrasenha = contrasenha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}
}
