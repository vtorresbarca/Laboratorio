package com.wirtz.vanesa.excepciones;

public class UsernameAlreadyExists extends Exception{

	private static final long serialVersionUID = 344278704042763938L;

	public UsernameAlreadyExists() {

	}
	
	public UsernameAlreadyExists(String mensaje) {
		super(mensaje);
	}
}
