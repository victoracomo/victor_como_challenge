package com.eldar.excepciones;

public class FechaVencimientoException extends RuntimeException{

	private static final long serialVersionUID = -9045659440741403855L;

	public FechaVencimientoException(String mensaje) {
		super(mensaje);
	}
	
	public FechaVencimientoException() {
		super();
	}
}
