package com.fabriziomasciangioli.implementaciones.mariadb;

public class ExcepcionPatrones extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	public ExcepcionPatrones(int id) {
		this.id = id;
	}

	@Override
	public String getMessage() {
		switch (id) {
		case 1:
			return "No es un correo valido";
		case 2:
			return "La contraseña debe tener al entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula."
					+ "NO puede tener otros símbolos.";
		default:
			return "Error en el patron";
		}
	}

}
