package com.wirtz.vanesa.negocio.servicios.user;

public class WrongPassword extends Exception {

	public WrongPassword() {
		super();
	}
	
	public WrongPassword(String mensaje) {
		super(mensaje);
	}
}
