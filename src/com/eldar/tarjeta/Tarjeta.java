package com.eldar.tarjeta;

public class Tarjeta {

	private String marca;
	private String numTarjeta;
	private String nombre;
	private String apellido;
	private String fechaVenc;
	private Tarjeta tarjeta;
	
	public Tarjeta(String marca, String numTarjeta, String nombre, String apellido, String fechaVenc) {
		this.marca = marca;
		this.numTarjeta = numTarjeta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaVenc = fechaVenc;		
	}
	
	public Tarjeta(Tarjeta tarjeta) {
		this.marca = tarjeta.getMarca();
		this.numTarjeta = tarjeta.getNumTarjeta();
		this.nombre = tarjeta.getNombre();
		this.apellido = tarjeta.getApellido();
		this.fechaVenc = tarjeta.getFechaVenc();
	}

	public String getMarca() {
		return marca;
	}
	
	public String getNumTarjeta() {
		return numTarjeta;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getFechaVenc() {
		return fechaVenc;
	}
}
