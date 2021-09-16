package com.fabriziomasciangioli.interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface Fechas {
	String FECHA_SQL = "yyyy-MM-dd";
	String FECHA_USUARIO = "dd/MM/yyyy";

	/**
	 * Metodo retorna un String con formato dd/MM/yyyy de un objeto Date
	 * 
	 * @param fecha
	 * @return String
	 */
	static String getFechaToString(Date fecha) {
		SimpleDateFormat formato = new SimpleDateFormat(FECHA_USUARIO);
		return formato.format(fecha);
	}

	/**
	 * Metodo retorna un objeto Date con formato dd/MM/yyyy de un String
	 * 
	 * @param fecha
	 * @return Date
	 * @throws ParseException
	 */
	static Date getStringToFecha(String fecha) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat(FECHA_USUARIO);
		return formato.parse(fecha);
	}

	/**
	 * Metodo retorna un String con formato yyyy-MM-dd de un objeto Date
	 * 
	 * @param fecha
	 * @return String
	 */
	static String getFechaToStringSQL(Date fecha) {
		return new SimpleDateFormat(FECHA_SQL).format(fecha);
	}

	/**
	 * Metodo retorna un objeto Date con formato yyyy-MM-dd de un String
	 * 
	 * @param fecha
	 * @return Date
	 * @throws ParseException
	 */
	static Date getStringToFechaSQL(String fecha) throws ParseException {
		return new SimpleDateFormat(FECHA_SQL).parse(fecha);
	}

}
