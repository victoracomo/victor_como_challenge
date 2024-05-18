package com.eldar.tarjeta;

import java.util.Objects;

import com.eldar.excepciones.ApellidoException;
import com.eldar.excepciones.FechaVencimientoException;
import com.eldar.excepciones.MarcaExcepcion;
import com.eldar.excepciones.NombreException;
import com.eldar.excepciones.NumTarjetaException;
import com.eldar.valueobject.CardHolder;
import com.eldar.valueobject.FechaVenc;
import com.eldar.valueobject.Marca;
import com.eldar.valueobject.NumTarjeta;

public class Nara {
	
	Marca marca;
	NumTarjeta numTarj;
	CardHolder card;
	FechaVenc fechaVenc;
	
	boolean flag = false;
	
	
	public void construirTarjeta(String paramMarca, String paramNumTarj, String paramNombre, String paramApellido, String paramFecVenc) {
		
		cargarMarca(paramMarca);		
		cargarNumTarjeta(paramNumTarj);
		cargarCardHolder(paramNombre, paramApellido);
		cargarFechaVencimiento(paramFecVenc);
		
		if(!flag) {
			mostrarTarjeta(marca, numTarj, card, fechaVenc);
		}
	}

	private void cargarMarca(String paramMarca) {
		try {
			marca = new Marca(paramMarca);
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch(MarcaExcepcion e) {
			e.printStackTrace();
		}
		
		if(Objects.isNull(marca)) {
			flag = true;
		}
	}
	
	private void cargarNumTarjeta(String paramNumTarj) {
		try {
			numTarj = new NumTarjeta(paramNumTarj);
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch(NumTarjetaException e) {
			e.printStackTrace();
		}
		
		if(Objects.isNull(numTarj)) {
			flag = true;
		}
	}
	
	private void cargarCardHolder(String paramNombre, String paramApellido) {
		try {
			card = new CardHolder(paramNombre, paramApellido);
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch(NombreException e) {
			e.printStackTrace();
		} catch(ApellidoException e) {
			e.printStackTrace();
		}
		
		if(Objects.isNull(card)) {
			flag = true;
		}
	}
	
	private void cargarFechaVencimiento(String paramFecVenc) {
		try {
			fechaVenc = new FechaVenc(paramFecVenc);
		} catch(NullPointerException e) {
			e.printStackTrace();
		} catch(FechaVencimientoException e) {
			e.printStackTrace();
		}
		
		if(Objects.isNull(fechaVenc)) {
			flag = true;
		}
	}
	
	private void mostrarTarjeta(Marca marca, NumTarjeta numTarj, CardHolder card, FechaVenc fechaVenc) {
		System.out.println("\n=============================\n"
				+ "Tarjeta:"
				+ "\n=============================");
		
		System.out.println("Marca: " + marca.getMarca());
		System.out.println("Numero: " + numTarj.getNumTarjeta());
		System.out.println("Nombre: " + card.getNombre());
		System.out.println("Apellido: " + card.getApellido());
		System.out.println("Fecha vencimiento: " + fechaVenc.getFechaVenc());
	}
	
	public float calcularTasa(String fechaVenc) {
		final float MULTIPLICADOR = (float) 0.5;
		
		Integer dia = Integer.valueOf(fechaVenc.substring(0, 2));
		float resultado = 1;
		
		try {
			resultado = dia * MULTIPLICADOR;
		} catch(ArithmeticException e) {
			e.getMessage();
		}
		
		return resultado;
	}
}
