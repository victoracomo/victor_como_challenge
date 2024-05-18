package com.eldar.valueobject;

import java.util.Objects;

import com.eldar.excepciones.NumTarjetaException;

public class NumTarjeta {
	private final static String VALIDAR_NUM_TARJETA = "Debe ingresar un valor numerico valido de 16 caracteres";
	
	String numTarjeta;
	
	public NumTarjeta(String numTarjeta) throws NullPointerException, NumTarjetaException {
		
		if(Objects.isNull(numTarjeta)) {
			throw new NullPointerException(VALIDAR_NUM_TARJETA);
		}

		if (!numTarjeta.matches("[0-9]*")) {
			throw new NumTarjetaException(VALIDAR_NUM_TARJETA);
		}
		
		if(numTarjeta.isEmpty()) {
			throw new NumTarjetaException(VALIDAR_NUM_TARJETA);
		}
		
		if(numTarjeta.length() != 16) {
			throw new NumTarjetaException(VALIDAR_NUM_TARJETA);
		}
		
		this.numTarjeta = numTarjeta;
	}
	
	public String getNumTarjeta() {
		return numTarjeta;
	}
}