<%@page import="com.fabriziomasciangioli.entities.Usuario"%>
<%@page import="com.fabriziomasciangioli.enumerados.Mensajes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/button.css">
<link rel="stylesheet" href="css/form.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/alert.css">

<title>Login</title>
</head>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");

if (null != usuario) {
	response.sendRedirect("index.jsp");
}

Mensajes mensaje = (Mensajes) request.getAttribute("mensaje");
%>

<body>
<%if(null!=mensaje){ %>
<div id="alert">
<a class="alert <%=mensaje.getClaseCSS() %>" href="#alert"><%=mensaje.getMensaje() %></a>

</div>
<%} %>
	<section>
		<form action="loginUsuario" method="post">

			<label for="correo">Correo</label> 
			<input type="email" id="correo" name="correo" required placeholder="usuario@dominio.com">
			<label for="clave">Clave</label> 
			<input type="password" id="clave" name="clave" required >
			<em id="verClave" class="bi bi-eye-slash"></em>
			<button type="submit" class="success">Enviar</button>
			<button type="reset" class="warning">Cancelar</button>


		</form>

		
		<script  src="scripts/Password.js"></script>
	</section>
</body>

</html>