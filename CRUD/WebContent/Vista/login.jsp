<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="Vista/css/default.css">
		<style>
			table {width: 30%;}
	   	</style>
	</head>
	<body>
		<h1>Login</h1>
		<table>
			<form action="servletUsuario?action=validarUsuario" method="post">
				<tr>
					<td><br>Usuario:<input type="text" name="usuario"><br><br></td>
				</tr>
				<tr>
				 	<td><br>Contrase�a:<input type="password" name="password"><br><br></td>
				</tr>
				<tr><th><input type="submit" value="Iniciar sesi�n"/></th></tr>
			</form>
		</table> 
		<table>
			<tr>
				<th><a href="servletUsuario?action=nuevoUsuario">Registrar nuevo usuario</a></th>			
			</tr>
			<tr>
				<th><a href="servletUsuario?action=index" >Volver</a> </td>
			</tr>
		</table>
	</body>
</html>