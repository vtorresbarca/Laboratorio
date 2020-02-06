package com.wirtz.vanesa.excepciones;

public class EditPasswordEmpty extends Exception {

	private static final long serialVersionUID = -548549157112212054L;

	public EditPasswordEmpty() {
		super();
	}
	
	public EditPasswordEmpty(String message) {
		super(message);
	}
}
