<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Bienvenido</title>
		<link rel="stylesheet" type="text/css" href="Vista/css/default.css">
	</head>
	<body>
		<h1>Bienvenido</h1>
		<table>
			<tr>	
				<th><a href="servletUsuario?action=login">Iniciar sesi�n</a></th>  
			</tr>
			<tr>
				<th><a href="servletUsuario?action=cerrarSesion">Cerrar sesi�n</a></th> 
			</tr>
			<tr>
				<th><a href="servletAlumno?action=mostrar">Listado de alumnos</a></th> 
			</tr> 
		</table>
	</body>
</html>