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
		<h1>Actualizar Alumno</h1>
		<form action="servletAlumno?action=editar" method="post" >
			<table>
				<tr>
					<th><a href="servletAlumno?action=mostrar" >Volver al menú</a></th>
				</tr>
			</table>
			<table>
				<tr>
					<td><label>Id</label></td>
					<td><input type="hidden" name="id" value='<c:out value="${alumno.id}"></c:out>' ></td>
				</tr>
				<tr>
					<td><label>No. Control</label></td>
					<td><input type="text" name="ncontrol" value='<c:out value="${alumno.ncontrol}"></c:out>' ></td>
				</tr>
				<tr>
					<td><label>Nombre</label></td>
					<td><input type="text" name="nombre" value='<c:out value="${alumno.nombre}"></c:out>' ></td>
				</tr>
				<tr>
					<td><label>Apellido paterno</label></td>
					<td><input type="text" name="paterno" value='<c:out value="${alumno.paterno}"></c:out>' ></td>
				</tr>
				<tr>
					<td><label>Apellido materno</label></td>
					<td><input type="text" name="materno" value='<c:out value="${alumno.materno}"></c:out>' ></td>
				</tr>
				<tr>
					<td><label>Curso</label></td>
					<td><input type="text" name="curso" value='<c:out value="${alumno.curso}"></c:out>' ></td>
				</tr>
				<tr>
					<td><label>Semestre</label></td>
					<td><input type="text" name="semestre" value='<c:out value="${alumno.semestre}"></c:out>' ></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td><input type="submit" name="actualizar" value="Actualizar"></td>
				</tr>
			</table> 
		</form>
	</body>
</html>