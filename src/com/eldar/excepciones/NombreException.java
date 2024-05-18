package com.eldar.excepciones;

public class NombreException extends RuntimeException{

	private static final long serialVersionUID = 8478598645687421784L;

	public NombreException(String mensaje) {
		super(mensaje);
	}
	
	public NombreException() {
		super();
	}
}
