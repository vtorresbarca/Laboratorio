package com.wirtz.vanesa.excepciones;

public class DifferentPasswords extends Exception{

	public DifferentPasswords() {
		super();
	}
	
	public DifferentPasswords(String mensaje) {
		super(mensaje);
	}
}
