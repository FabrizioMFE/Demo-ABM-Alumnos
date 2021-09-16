package com.fabriziomasciangioli.enumerados;

public enum Mensajes {
	USUARIO_INACTIVO("Usuario Inactivo, contacte al administrador","alertDanger"),
	CREDENCIALES_INCORRECTAS("Credenciales Incorrectas","alertWarning"),
	REGISTRO_AGREGADO("Se ha agregado correctamente el registro","alertSuccess"),
	REGISTRO_ELIMINADO("El registro se ha eliminado correctamente","alertWarning"),
	CERRAR_SESION("Ha cerrado sesion correctamente","alertWarning"),
	ERROR("Ha ocurrido un error, comuniquese con el administrador","alertDanger");
	private String mensaje;
	private String claseCSS;
	
	private Mensajes(String mensaje, String claseCSS) {
		this.mensaje = mensaje;	
		this.claseCSS = claseCSS;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getClaseCSS() {
		return claseCSS;
	}

}
