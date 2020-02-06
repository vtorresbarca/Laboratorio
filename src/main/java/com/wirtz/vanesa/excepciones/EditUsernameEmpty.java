package com.wirtz.vanesa.excepciones;

public class EditUsernameEmpty extends Exception {
	
	private static final long serialVersionUID = 344278704042763938L;

	public EditUsernameEmpty() {

	}
	
	public EditUsernameEmpty(String mensaje) {
		super(mensaje);
	}
}
