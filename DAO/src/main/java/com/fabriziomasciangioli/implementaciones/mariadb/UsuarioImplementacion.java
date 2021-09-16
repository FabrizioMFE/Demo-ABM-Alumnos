package com.fabriziomasciangioli.implementaciones.mariadb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fabriziomasciangioli.entities.Usuario;
import com.fabriziomasciangioli.interfaces.ConexionMariaDB;
import com.fabriziomasciangioli.interfaces.DAO;

public class UsuarioImplementacion implements DAO<Usuario, String>, ConexionMariaDB {
	private PreparedStatement psInsertar;
	private PreparedStatement psModificar;
	private PreparedStatement psEliminar;
	private PreparedStatement psBuscar;
	private PreparedStatement psListar;
	private final String KEY = "Digitalers1";

	private boolean insertar(Usuario usuario) {
		String query = "insert into usuarios (correo, clave, activo) values" + "(?, AES_ENCRYPT(?, ?), ?)";

		try {
			if (null == psInsertar) {
				psInsertar = getConexion().prepareStatement(query);
			}
			psInsertar.setString(1, usuario.getCorreo());
			psInsertar.setString(2, usuario.getClave());
			psInsertar.setString(3, KEY);
			psInsertar.setBoolean(4, usuario.isActivo());

			return psInsertar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	private boolean modificar(Usuario usuario) {
		String query = "update usuarios set clave = AES_ENCRYPT(?, ?), activo = ? where correo = ?";
		try {
			if (null == psModificar) {
				psModificar = getConexion().prepareStatement(query);
			}
			psModificar.setString(1, usuario.getClave());
			psModificar.setString(2, KEY);
			psModificar.setBoolean(3, usuario.isActivo());
			psModificar.setString(4, usuario.getCorreo());

			return psModificar.executeUpdate() == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean guardar(Usuario usuario) {
		if (null == buscar(usuario.getCorreo())) {
			return insertar(usuario);
		} else {
			return modificar(usuario);
		}
	}

	@Override
	public boolean eliminar(Usuario usuario) {
		String query = "delete from usuarios where correo = ?";
		try {
			if (null == psEliminar) {
				psEliminar = getConexion().prepareStatement(query);
			}
			psEliminar.setString(1, usuario.getCorreo());

			return psEliminar.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Usuario buscar(String correo) {
		String query = "select correo, CAST(AES_DECRYPT(clave, ?) as VARCHAR(100)) as clave, activo from usuarios where correo = ?";
		try {
			if (null == psBuscar) {
				psBuscar = getConexion().prepareStatement(query);
			}
			psBuscar.setString(1, KEY);
			psBuscar.setString(2, correo);
			
			ResultSet resultado = psBuscar.executeQuery();
			if (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setCorreo(resultado.getString("correo"));
				usuario.setClave(resultado.getString("clave"));
				usuario.setActivo(resultado.getBoolean("activo"));
				return usuario;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionPatrones e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		String query = "select correo, CAST(AES_DECRYPT(clave, ?) as VARCHAR(100)) as clave, activo from usuarios";
		try {
			if (null == psListar) {
				psListar = getConexion().prepareStatement(query);
			}
			psListar.setString(1, KEY);
			
			ResultSet resultado = psListar.executeQuery();
			
			while(resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setCorreo(resultado.getString("correo"));
				usuario.setClave(resultado.getString("clave"));
				usuario.setActivo(resultado.getBoolean("activo"));
				
				usuarios.add(usuario);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionPatrones e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}

}
