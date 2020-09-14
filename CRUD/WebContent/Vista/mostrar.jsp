<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Administrar Alumnos</title>
		<link rel="stylesheet" type="text/css" href="Vista/css/default.css">
	</head>
	<body>
		<h1>Administrar Alumnos</h1>
		<table>
			<tr>
				<th><a href="servletAlumno?action=nuevo">Registrar Alumno</a></th>			
			</tr>
			<tr>
				<th><a href="servletAlumno?action=mostrar">Mostrar Alumnos</a></th>
			</tr>
			<tr>
				<th><a href="servletUsuario?action=cerrarSesion">Cerrar Sesion</a></th>
			</tr>
		</table>
		<br>
		<form action="servletAlumno?action=buscarId" method="post">
			<table>
				<tr>
					<th>Buscar alumno por ID:</th>
					<td><input type="text" name="id"/></td>
					<td><input type="submit" value="Buscar" name="buscar"></td>	
				</tr>
			</table>
		</form>
		<br>
		<table>
			<tr>
			 <th>Id</th>
			 <th>No. Control</th>
			 <th>Nombre</th>
			 <th>Apellido paterno</th>
			 <th>Apellido materno</th>
			 <th>Curso</th>
			 <th>Semestre</th>
			 <th colspan=2>Acciones</th>
			</tr>
			<c:forEach var="alumno" items="${lista}">
				<tr>
					<td><c:out value="${alumno.id}"/></td>
					<td><c:out value="${alumno.ncontrol}"/></td>
					<td><c:out value="${alumno.nombre}"/></td>
					<td><c:out value="${alumno.paterno}"/></td>
					<td><c:out value="${alumno.materno}"/></td>
					<td><c:out value="${alumno.curso}"/></td>
					<td><c:out value="${alumno.semestre}"/></td>
					<th><a href="servletAlumno?action=showeditar&id=<c:out value="${alumno.id}" />">Editar</a></th>
					<th><a href="servletAlumno?action=eliminar&id=<c:out value="${alumno.id}"/>">Eliminar</a> </th>				
				</tr>
			</c:forEach>
		</table>
	</body>
</html>