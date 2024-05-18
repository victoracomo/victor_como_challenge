package com.eldar.valueobject;

import java.util.Objects;

import com.eldar.excepciones.MarcaExcepcion;
import com.eldar.excepciones.NombreException;

public class Marca {

	private final static String VALIDAR_MARCA = "Debe ingresar el nombre de la tarjeta (marca) valido menor a 7 caracteres";
	
	String marca;
	
	public Marca(String marca) throws NullPointerException, MarcaExcepcion {
		
		if(Objects.isNull(marca)) {
			throw new NullPointerException(VALIDAR_MARCA);
		}
		
		if(marca.isEmpty() || marca.length() > 6) {
			throw new MarcaExcepcion(VALIDAR_MARCA);
		}
				
		this.marca = marca;
	}
	
	public String getMarca() {
		return marca;
	}
}
