package com.eldar.valueobject;

import java.util.Objects;

import com.eldar.excepciones.FechaVencimientoException;

public class FechaVenc {

	private final static String VALIDAR_FECHA_VENC = "El formato de la fecha debe ser dos digitos numericos para el dia, dos digitos numericos para el mes y dos digitos numericos para el año";
	
	String fechaVenc;
	
	public FechaVenc(String paramFechaVenc) throws NullPointerException, FechaVencimientoException {
		
		if(Objects.isNull(paramFechaVenc)) {
			throw new NullPointerException(VALIDAR_FECHA_VENC);
		}
		
		if(paramFechaVenc.isEmpty()) {
			throw new FechaVencimientoException(VALIDAR_FECHA_VENC);
		}
		
		if(paramFechaVenc.length() != 6) {
			throw new FechaVencimientoException(VALIDAR_FECHA_VENC);
		}
		
		if (!paramFechaVenc.matches("[0-9]*")) {
			throw new FechaVencimientoException(VALIDAR_FECHA_VENC);
		}
		
		String dia = paramFechaVenc.substring(0, 2);
		if(Integer.valueOf(dia).intValue() < 1 || Integer.valueOf(dia).intValue() > 31) {
			throw new FechaVencimientoException(VALIDAR_FECHA_VENC);
		}
		
		String mes = paramFechaVenc.substring(2, 4);
		if(Integer.valueOf(mes).intValue() < 1 || Integer.valueOf(mes).intValue() > 12) {
			throw new FechaVencimientoException(VALIDAR_FECHA_VENC);
		}
		
		String anio = paramFechaVenc.substring(4, 6);
		if(Integer.valueOf(anio).intValue() < 01 || Integer.valueOf(mes).intValue() > 99) {
			throw new FechaVencimientoException(VALIDAR_FECHA_VENC);
		}
				
		this.fechaVenc = dia.toString() + "/" + mes.toString() + "/" + anio.toString();
	}
	
	public String getFechaVenc() {
		return fechaVenc;
	}
}
