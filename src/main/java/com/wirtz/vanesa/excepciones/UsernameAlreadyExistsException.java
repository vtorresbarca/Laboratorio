package com.wirtz.vanesa.excepciones;

public class UsernameAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 344278704042763938L;

	public UsernameAlreadyExistsException() {

	}
	
	public UsernameAlreadyExistsException(String mensaje) {
		super(mensaje);
	}
}
