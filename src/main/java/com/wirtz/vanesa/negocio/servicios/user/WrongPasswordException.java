package com.wirtz.vanesa.negocio.servicios.user;

public class WrongPasswordException extends Exception {

	public WrongPasswordException() {
		super();
	}
	
	public WrongPasswordException(String mensaje) {
		super(mensaje);
	}
}
