package com.eldar.excepciones;

public class ApellidoException extends RuntimeException{

	private static final long serialVersionUID = 3819113088335679298L;

	public ApellidoException(String mensaje) {
		super(mensaje);
	}
	
	public ApellidoException() {
		super();
	}
}
