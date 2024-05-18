package com.eldar.main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import com.eldar.tarjeta.Amex;
import com.eldar.tarjeta.Nara;
import com.eldar.tarjeta.Tarjeta;
import com.eldar.tarjeta.Visa;
import com.eldar.varios.IngresoCampos;

public class Main {

	private static final Integer MONTO_LIMITE = 1000;
	Tarjeta tarjeta = null;
	Tarjeta tarjetaAnterior = null;
	Boolean flagTarjetaAnterior = false;

	private void ingresarTarjeta() {

		if (flagTarjetaAnterior) {
			tarjetaAnterior = new Tarjeta(tarjeta);
		}

		IngresoCampos ingreso = new IngresoCampos();
		tarjeta = new Tarjeta(ingreso.getMarca(), ingreso.getNumTarjeta(), ingreso.getNombre(), ingreso.getApellido(),
				ingreso.getFechaVenc());

		if (Objects.isNull(tarjetaAnterior)) {
			tarjetaAnterior = new Tarjeta("", "", "", "", "");
		}

		flagTarjetaAnterior = true;
	}

	private String leerConsola() {
		Scanner sc = new Scanner(System.in, "UTF-8");
		String opcion = sc.nextLine();
		return opcion;
	}

	private void invocarTarjeta(Tarjeta tarjeta) {

		switch (tarjeta.getMarca()) {
		case "VISA":
			Visa visa = new Visa();
			visa.construirTarjeta(tarjeta.getMarca(), tarjeta.getNumTarjeta(), tarjeta.getNombre(),
					tarjeta.getApellido(), tarjeta.getFechaVenc());
			break;

		case "NARA":
			Nara nara = new Nara();
			nara.construirTarjeta(tarjeta.getMarca(), tarjeta.getNumTarjeta(), tarjeta.getNombre(),
					tarjeta.getApellido(), tarjeta.getFechaVenc());
			break;

		case "AMEX":
			Amex amex = new Amex();
			amex.construirTarjeta(tarjeta.getMarca(), tarjeta.getNumTarjeta(), tarjeta.getNombre(),
					tarjeta.getApellido(), tarjeta.getFechaVenc());
			break;

		default:
			System.out.println("Marca no identificada");
			break;
		}
	}

	private void validarOperacion() {

		System.out.println("\nIngrese el monto a validar: ");

		String monto = leerConsola();
		while (Objects.isNull(monto) || monto.isEmpty() || !monto.matches("[0-9]*")) {
			System.out.println("Reingrese el monto a validar: ");
			monto = leerConsola();
		}

		Integer montoEntero = Integer.valueOf(monto);
		if (montoEntero <= MONTO_LIMITE) {
			System.out.println("El monto es menor que el limite establecido (U$S 1000)\n");
		} else {
			System.out.println("El monto es superior al limite establecido (U$S 1000)\n");
		}
	}

	private void validarTarjeta(String fechaVenc) {

		System.out.println("\nSe compara la fecha de la tarjeta con la fecha de la transaccion");

		String fechaActual = new SimpleDateFormat("dd/MM/yy").format(new Date());
		fechaVenc = fechaVenc.substring(0, 2) + "/" + fechaVenc.substring(2, 4) + "/" + fechaVenc.substring(4, 6);

		System.out.println("Se muestra el dia, el mes y anio presente: " + fechaActual);
		System.out.println("Se muestra el dia, el mes y anio de la tarjeta: " + fechaVenc);

		Integer diaHoy = Integer.valueOf(fechaActual.substring(0, 2));
		Integer mesHoy = Integer.valueOf(fechaActual.substring(3, 5));
		Integer anioHoy = Integer.valueOf(fechaActual.substring(6, 8));

		Integer diaTarjeta = Integer.valueOf(fechaVenc.substring(0, 2));
		Integer mesTarjeta = Integer.valueOf(fechaVenc.substring(3, 5));
		Integer anioTarjeta = Integer.valueOf(fechaVenc.substring(6, 8));

		if (anioTarjeta < anioHoy) {
			System.out.println("Tarjeta vencida");
		} else {
			if (anioTarjeta.equals(anioHoy)) {
				if (mesTarjeta < mesHoy) {
					System.out.println("Tarjeta vencida");
				} else {
					if (mesTarjeta.equals(mesHoy)) {
						if (diaTarjeta < diaHoy) {
							System.out.println("Tarjeta vencida");
						} else {
							System.out.println("Tarjeta valida");
						}
					}
				}
			} else {
				System.out.println("Tarjeta valida");
			}
		}
	}

	private void compararTarjeta() {
		System.out.println("\nComparar tarjetas");
		String fechaTarjAnt = "";
		
		if(Objects.isNull(tarjetaAnterior.getFechaVenc()) || tarjetaAnterior.getFechaVenc().isEmpty()) {
			fechaTarjAnt = "000000";
		} else {
			fechaTarjAnt = tarjetaAnterior.getFechaVenc(); 
		}
				
		fechaTarjAnt = fechaTarjAnt.substring(0, 2) + "/" + fechaTarjAnt.substring(2, 4) + "/" + fechaTarjAnt.substring(4, 6);
		
		String fechaTarj = tarjeta.getFechaVenc(); 
		fechaTarj = fechaTarj.substring(0, 2) + "/" + fechaTarj.substring(2, 4) + "/" + fechaTarj.substring(4, 6);
		
		System.out.println("\nLa tarjeta anterior es: " + "\n Marca: " + tarjetaAnterior.getMarca() + "\n Num tarjeta: "
				+ tarjetaAnterior.getNumTarjeta() + "\n Nombre: " + tarjetaAnterior.getNombre() + "\n Apellido: "
				+ tarjetaAnterior.getApellido() + "\n Fecha vencimiento: " + fechaTarjAnt);

		System.out.println("\nLa tarjeta actual es: " + "\n Marca: " + tarjeta.getMarca() + "\n Num tarjeta: "
				+ tarjeta.getNumTarjeta() + "\n Nombre: " + tarjeta.getNombre() + "\n Apellido: "
				+ tarjeta.getApellido() + "\n Fecha vencimiento: " + fechaTarj);
	}

	private void calcularTasa() {
		
		switch (tarjeta.getMarca()) {
		case "VISA":
			Visa visa = new Visa();
			System.out.println("La tasa para la tarjeta " + tarjeta.getMarca() + " es: "
					+ visa.calcularTasa(tarjeta.getFechaVenc()));
			break;

		case "NARA":
			Nara nara = new Nara();
			System.out.println("La tasa para la tarjeta " + tarjeta.getMarca() + " es: "
					+ nara.calcularTasa(tarjeta.getFechaVenc()));
			break;

		case "AMEX":
			Amex amex = new Amex();
			System.out.println("La tasa para la tarjeta " + tarjeta.getMarca() + " es: "
					+ amex.calcularTasa(tarjeta.getFechaVenc()));
			break;

		default:
			System.out.println("Marca no identificada");
			break;
		}
	}

	private void menu(Tarjeta tarjeta) {
		String opcion;
		System.out.println("\nIngrese la opcion deseada: ");
		System.out.println("\nIngrese A si desea ingresar nueva tarjeta: ");
		System.out.println("Ingrese B si desea invocar tarjeta: ");
		System.out.println("Ingrese C si desea validar operacion: ");
		System.out.println("Ingrese D si desea validar tarjeta (fecha vencimiento): ");
		System.out.println("Ingrese E si desea comparar tarjetas: ");
		System.out.println("Ingrese F si desea ver la tasa de interes de su tarjeta: ");
		System.out.println("Ingrese G si desea salir del aplicativo: ");
		opcion = leerConsola().toUpperCase();

		while (!opcion.matches("[A-Z]*")) {
			System.out.println("\nReingrese la opcion deseada: ");
			System.out.println("\nIngrese A si desea ingresar nueva tarjeta: ");
			System.out.println("Ingrese B si desea invocar tarjeta: ");
			System.out.println("Ingrese C si desea validar operacion: ");
			System.out.println("Ingrese D si desea validar tarjeta (fecha vencimiento): ");
			System.out.println("Ingrese E si desea comparar tarjetas: ");
			System.out.println("Ingrese F si desea ver la tasa de interes de su tarjeta: ");
			System.out.println("Ingrese G si desea salir del aplicativo: ");
			opcion = leerConsola().toUpperCase();
		}

		switch (opcion) {
		case "A":
			ingresarTarjeta();
			break;
		case "B":
			invocarTarjeta(this.tarjeta);
			break;
		case "C":
			validarOperacion();
			break;
		case "D":
			validarTarjeta(this.tarjeta.getFechaVenc());
			break;
		case "E":
			compararTarjeta();
			break;
		case "F":
			calcularTasa();
			break;
		case "G":
			System.exit(0);
		default:
			menu(tarjeta);
		}
		menu(tarjeta);
	}

	public static void main(String[] args) {

		Main app = new Main();

		app.ingresarTarjeta();
		try {
			app.menu(app.tarjeta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
