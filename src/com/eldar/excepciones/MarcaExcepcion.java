package com.eldar.excepciones;

public class MarcaExcepcion extends RuntimeException{

	private static final long serialVersionUID = -4018583698120267843L;

	public MarcaExcepcion(String mensaje) {
		super(mensaje);
	}
	
	public MarcaExcepcion() {
		super();
	}
}
