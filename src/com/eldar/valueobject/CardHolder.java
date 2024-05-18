package com.eldar.valueobject;

import java.util.Objects;

import com.eldar.excepciones.ApellidoException;
import com.eldar.excepciones.NombreException;

public class CardHolder {
	
	private final static String VALIDAR_CARDHOLDER = "Debe ingresar un valor valido menor a 20 caracteres";

	private String nombre;
	private String apellido;
	
	public CardHolder(String nombre, String apellido) throws NullPointerException, NombreException, ApellidoException {
		
		if(Objects.isNull(nombre)) {
			throw new NullPointerException("Nombre - " + VALIDAR_CARDHOLDER); 
		}
		
		if(!nombre.matches("[A-Z]*")) {
			throw new NullPointerException("Nombre - " + VALIDAR_CARDHOLDER);
		}
		
		if(nombre.isEmpty() || nombre.length() > 20) {
			throw new NombreException("Nombre - " + VALIDAR_CARDHOLDER);
		}
		
		if(Objects.isNull(apellido)) {
			throw new NullPointerException("Apellido - " + VALIDAR_CARDHOLDER);
		}
		
		if(!apellido.matches("[A-Z]*")) {
			throw new NullPointerException("Apellido - " + VALIDAR_CARDHOLDER);
		}
		
		if(apellido.isEmpty() || apellido.length() > 20) {
			throw new ApellidoException("Apellido - " + VALIDAR_CARDHOLDER);
		}
		
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
}
