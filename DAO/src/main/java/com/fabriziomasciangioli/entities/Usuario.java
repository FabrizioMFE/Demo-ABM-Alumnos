package com.fabriziomasciangioli.entities;

import com.fabriziomasciangioli.implementaciones.mariadb.ExcepcionPatrones;
import com.fabriziomasciangioli.interfaces.Patrones;

public class Usuario {
	private String correo;
	private String clave;
	private boolean activo;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) throws ExcepcionPatrones {
		if (!Patrones.esCorreo(correo)) {
			throw new ExcepcionPatrones(1);			
		}
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) throws ExcepcionPatrones {
		if (!Patrones.esClave(clave)) {
			throw new ExcepcionPatrones(2);			
		}
		this.clave = clave;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Usuario(String correo, String clave, boolean activo) throws ExcepcionPatrones {
		super();
		setCorreo(correo);
		setClave(clave);
		this.activo = activo;
	}

	public Usuario() {
		super();
	}

	@Override
	public String toString() {
		return "Usuario [" + correo + ", " + clave + ", " + activo + "]";
	}

}
