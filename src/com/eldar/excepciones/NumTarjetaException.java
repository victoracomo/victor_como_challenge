package com.eldar.excepciones;

public class NumTarjetaException extends RuntimeException {

	private static final long serialVersionUID = -1532556382000802392L;

	public NumTarjetaException(String mensaje) {
		super(mensaje);
	}
	
	public NumTarjetaException() {
		super();
	}
}
