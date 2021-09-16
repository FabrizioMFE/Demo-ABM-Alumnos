<%@page import="com.fabriziomasciangioli.interfaces.Fechas"%>
<%@page import="com.fabriziomasciangioli.entities.Documento"%>
<%@page
	import="com.fabriziomasciangioli.implementaciones.mariadb.AlumnoImplementacion"%>
<%@page import="com.fabriziomasciangioli.entities.Alumno"%>
<%@page import="com.fabriziomasciangioli.entities.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/button.css">
<link rel="stylesheet" href="css/form.css">
<title>ABM Alumno</title>
</head>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if (null == usuario) {
	response.sendRedirect("login.jsp");
}

String tipoDocumento = request.getParameter("tipoDocumento");
String numeroDocumento = request.getParameter("numeroDocumento");
Boolean editar = Boolean.valueOf(request.getParameter("editar"));
Alumno alumno = null;

if (null != tipoDocumento && null != numeroDocumento && null != editar && editar) {
	AlumnoImplementacion alumnoImplementacion = new AlumnoImplementacion();
	alumno = alumnoImplementacion.buscar(new Documento(tipoDocumento, numeroDocumento));
}
%>
<body>

	<header>
	<a href="index.jsp">ABM de Alumnos</a>
	
	<img alt="Educacion IT" src="images/logo-it.svg" width="200" height="50">
	<h4>Digitalers</h4>
	</header>
	<nav>
		<a href="index.jsp">Lista Alumnos</a> <a
			href="/loginUsuario?cerrarSesion=true">Cerrar Sesion</a>
	</nav>
	<section>
		<form action="AlumnoControlador" method="post">
			<label for="tipoDocumento">Tipo Documento</label>
			<%
			if (!editar) {
			%>
			<select name="tipoDocumento" id="tipoDocumento" required>
				<option value="">Seleccione un Tipo de Documento</option>
				<option value="DNI">DNI</option>
				<option value="PAS">PAS</option>
				<option value="CI">CI</option>
				<option value="LE">LE</option>
			</select>
			<%
			} else {
			%>
			<input type="text" name="tipoDocumento" id="tipoDocumento"
				placeholder="Tipo Documento" readonly
				value="<%=editar ? alumno.getDocumento().getTipo() : ""%>">

			<%
			}
			%>
			<label for="numeroDocumento">Numero Documento</label>
			<input type="text" name="numeroDocumento" id="numeroDocumento" placeholder="Numero Documento" <%=editar ? "readonly" : ""%>	value="<%=editar ? alumno.getDocumento().getNumero() : ""%>" required>
			
			<label for="descripcion">Nombre y Apellido</label>
			<input type="text" name="descripcion" id="descripcion" placeholder="Nombre y Apellido" value="<%=editar ? alumno.getDescripcion() : ""%>" required>
			
			<label for="fechaNacimiento">Fecha de Nacimiento</label>
			<input type="date" name="fechaNacimiento" id="fechaNacimiento" value="<%=editar ? Fechas.getFechaToStringSQL(alumno.getFechaNacimiento()) : ""%>" required>
			
			<label for="activo">Activo</label>
			<select	name="activo" required>
				<option value="">Seleccione una opcion</option>
				<option <%=editar && alumno.isActivo() ? "selected" : ""%> value="true">Activo</option>
				<option <%=editar && alumno.isActivo() ? "" : "selected"%> value="false">Inactivo</option>
			</select>

			<button class="success" type="submit">Enviar</button>
			<%if(editar){ %>
			<a class="warning" href="index.jsp" style="text-decoration:none">Cancelar</a>
			
			<%}else{ %>
			<button class="warning" type="reset">Limpiar</button>
			<%} %>
			

		</form>
	</section>

	<footer> Creado por Fabrizio Masciangioli</footer>

</body>
</html>