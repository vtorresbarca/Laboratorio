package com.wirtz.vanesa.excepciones;

public class DifferentPasswordsException extends Exception{

	public DifferentPasswordsException() {
		super();
	}
	
	public DifferentPasswordsException(String mensaje) {
		super(mensaje);
	}
}
