package com.fabriziomasciangioli.entities;

import java.util.Date;

public class Alumno {
	private Documento documento;
	private String descripcion;
	private Date fechaNacimiento;
	private boolean activo;

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Alumno(Documento documento, String descripcion, Date fechaNacimiento, boolean activo) {
		super();
		this.documento = documento;
		this.descripcion = descripcion;
		this.fechaNacimiento = fechaNacimiento;
		this.activo = activo;
	}

	public Alumno() {
		super();
	}

	@Override
	public String toString() {
		return "Alumno [" + documento + ", " + descripcion + ", " + fechaNacimiento + ", " + activo + "]";
	}

}
