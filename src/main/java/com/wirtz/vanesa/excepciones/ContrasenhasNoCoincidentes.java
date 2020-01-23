package com.wirtz.vanesa.excepciones;

public class ContrasenhasNoCoincidentes extends Exception{

	public ContrasenhasNoCoincidentes() {
		super();
	}
	
	public ContrasenhasNoCoincidentes(String mensaje) {
		super(mensaje);
	}
}
