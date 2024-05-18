package com.eldar.varios;

import java.util.Objects;
import java.util.Scanner;

public class IngresoCampos {
	
	private String leerConsola() {		
		Scanner sc = new Scanner(System.in, "UTF-8");
		String opcion = sc.nextLine();		
		return opcion;
	}

	public String getMarca() {
		String marca = "";
		System.out.println("Ingrese la marca de la tarjeta (VISA, NARA, AMEX en mayusculas): ");
		marca = leerConsola().toUpperCase();
		while(Objects.isNull(marca) || marca.isEmpty() || marca.length() > 4 || !marca.matches("^(VISA|NARA|AMEX)$")) {
			System.out.println("Reingrese la marca de la tarjeta (VISA, NARA, AMEX en mayusculas): ");
			marca = leerConsola().toUpperCase();
		}		
		return marca;
	}
	
	public String getNumTarjeta() {
		String numTarjeta = "";
		System.out.println("\nIngrese el numero de la tarjeta: ");
		numTarjeta = leerConsola();
		while(Objects.isNull(numTarjeta) || (numTarjeta.isEmpty() || !numTarjeta.matches("[0-9]*") || numTarjeta.length() != 16)) {
			System.out.println("Reingrese el numero de la tarjeta (Deben ser 16 caracteres numericos): ");
			numTarjeta = leerConsola();
		}		
		return numTarjeta;
	}

	public String getNombre() {
		String nombre = "";
		System.out.println("\nIngrese el nombre del asociado: ");
		nombre = leerConsola().toUpperCase();
		while(Objects.isNull(nombre) || nombre.isEmpty() || nombre.length() > 20 || !nombre.matches("[A-Z]*")) {
			System.out.println("Reingrese el nombre del asociado (menor a 20 caracteres): ");
			nombre = leerConsola();
		}
		return nombre;
	}

	public String getApellido() {
		String apellido = "";
		System.out.println("\nIngrese el apellido del asociado: ");
		apellido = leerConsola().toUpperCase();
		while(Objects.isNull(apellido) || apellido.isEmpty() || apellido.length() > 20 || !apellido.matches("[A-Z]*")) {
			System.out.println("Reingrese el apellido del asociado (menor a 20 caracteres): ");
			apellido = leerConsola();
		}	
		return apellido;
	}

	public String getFechaVenc() {
		String dia = "";
		String mes = "";
		String anio = "";
		
		System.out.println("\nIngrese el dia de la fecha de vencimiento (de 01 a 31): ");		
		dia = leerConsola();
		while(Objects.isNull(dia) ||
				dia.isEmpty() ||
				dia.length() != 2 ||
				!dia.matches("[0-9]*") ||
				Integer.valueOf(dia).intValue() < 1 ||
				Integer.valueOf(dia).intValue() > 31) {
			System.out.println("Reingrese el dia de la fecha de vencimiento (de 01 a 31): ");
			dia = leerConsola();
		}
		
		System.out.println("\nIngrese el mes de la fecha de vencimiento (de 01 a 12): ");		
		mes = leerConsola();
		while(Objects.isNull(mes) ||
				mes.isEmpty() ||
				mes.length() != 2 ||
				!mes.matches("[0-9]*") ||
				Integer.valueOf(mes).intValue() < 1 ||
				Integer.valueOf(mes).intValue() > 12) {
			System.out.println("Reingrese el mes de la fecha de vencimiento (de 01 a 12): ");
			mes = leerConsola();
		}
		
		System.out.println("\nIngrese el anio de la fecha de vencimiento (de 01 a 99): ");		
		anio = leerConsola();
		while(Objects.isNull(anio) ||
				anio.isEmpty() ||
				anio.length() != 2 ||
				!mes.matches("[0-9]*") ||
				Integer.valueOf(anio).intValue() < 1 ||
				Integer.valueOf(anio).intValue() > 99) {
			System.out.println("Reingrese el anio de la fecha de vencimiento (de 01 a 99): ");
			anio = leerConsola();
		}
		
		return dia + mes + anio;
	}
}
