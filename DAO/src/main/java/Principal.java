import java.text.ParseException;

import com.fabriziomasciangioli.entities.Alumno;
import com.fabriziomasciangioli.entities.Documento;
import com.fabriziomasciangioli.entities.Usuario;
import com.fabriziomasciangioli.implementaciones.mariadb.AlumnoImplementacion;
import com.fabriziomasciangioli.implementaciones.mariadb.ExcepcionPatrones;
import com.fabriziomasciangioli.implementaciones.mariadb.UsuarioImplementacion;
import com.fabriziomasciangioli.interfaces.Fechas;

public class Principal {
	public static void main(String[] args) throws ParseException {
	/*	AlumnoImplementacion impl = new AlumnoImplementacion();

		for (Alumno alumno : impl.listar()) {
			System.out.println(alumno);
		}
		
		Alumno alumno1 = new Alumno();
		alumno1.setDocumento(new Documento("DNI", "88"));
		alumno1.setDescripcion("M");
		alumno1.setFechaNacimiento(Fechas.getStringToFecha("15/03/1983"));
		alumno1.setActivo(true);
		
		impl.guardar(alumno1);*/
		
		try {
			Usuario usuario1 = new Usuario("user1@gmail.com", "User1abc", true);
			UsuarioImplementacion impl = new UsuarioImplementacion();
			impl.guardar(usuario1);
			
			for (Usuario usuario : impl.listar()) {
				System.out.println(usuario);
				
			}
			System.out.println("buscar: " + impl.buscar("user1@gmail.com"));
			
		} catch (ExcepcionPatrones e) {
			e.printStackTrace();
		}
		
	
		
	}
}
