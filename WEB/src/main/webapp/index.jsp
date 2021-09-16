<%@page import="com.fabriziomasciangioli.enumerados.Mensajes"%>
<%@page import="com.fabriziomasciangioli.interfaces.Fechas"%>
<%@page import="com.fabriziomasciangioli.entities.Alumno"%>
<%@page
	import="com.fabriziomasciangioli.implementaciones.mariadb.AlumnoImplementacion"%>
<%@page import="com.fabriziomasciangioli.entities.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/button.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/alert.css">

<title>Inicio</title>
</head>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if (null == usuario) {
	response.sendRedirect("login.jsp");
}

Mensajes mensaje = (Mensajes) request.getAttribute("mensaje");
%>
<body>
	
	<%if(null!=mensaje){ %>
<div id="alert">
<a class="alert <%=mensaje.getClaseCSS() %>" href="#alert"><%=mensaje.getMensaje() %></a>

</div>
<%} %>
	
	<header>
	<a href="index.jsp">ABM de Alumnos</a>
	
	<img alt="Educacion IT" src="images/logo-it.svg" width="200" height="50">
	<h4>Digitalers</h4>
	</header>
	<nav>
		<a href="alumno.jsp">Agregar Alumnos</a> <a
			href="loginUsuario?cerrarSesion=true">Cerrar Sesion</a>
	</nav>
	<section>
		<h2>Lista de Alumnos</h2>

		<table>
			<tr>
				<th>Documento</th>
				<th>Descripcion</th>
				<th>Fecha de Nacimiento</th>
				<th>Activo</th>
				<th>Accion</th>
			</tr>

			<%
			AlumnoImplementacion alumnoImplementacion = new AlumnoImplementacion();
			for (Alumno alumno : alumnoImplementacion.listar()) {
			%>


			<tr>
				<td><%=alumno.getDocumento().getTipo().concat(" - ").concat(alumno.getDocumento().getNumero())%></td>
				<td><%=alumno.getDescripcion()%></td>
				<td><%=Fechas.getFechaToString(alumno.getFechaNacimiento())%></td>
				<td><%=alumno.isActivo() ? "Si" : "No"%></td>
				<td>
					<button class="warning"
						onclick="window.location.href='alumno.jsp?editar=true&tipoDocumento=<%=alumno.getDocumento().getTipo()%>&numeroDocumento=<%=alumno.getDocumento().getNumero()%>'">Modificar</button>
					<button class="danger"
						onclick="confirmar('Desea eliminar el registro <%=alumno.getDocumento()%>?')?window.location.href='AlumnoControlador?tipoDocumento=<%=alumno.getDocumento().getTipo()%>&numeroDocumento=<%=alumno.getDocumento().getNumero()%>':window.location.href='#'">Eliminar</button>

					
				</td>
			</tr>
			<%
			}
			%>
		</table>



	</section>

	<footer> Creado por Fabrizio Masciangioli </footer>

	<script src="scripts/confirm.js"></script>
</body>
</html>