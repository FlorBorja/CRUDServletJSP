package com.flor.alumno.dao;

import com.flor.alumno.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flor.alumno.modelo.Usuario;
import com.flor.alumno.modelo.Conexion;

public class UsuarioDAO {
	
	private Conexion con;
	private Connection connection;
	
	public UsuarioDAO (String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//INSERTAR USUARIO
	public boolean insertarUsuario (Usuario usuario) throws SQLException{
		
		String sql = "INSERT INTO usuario (id, usuario, password) VALUES (?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, usuario.getUsuario());
		statement.setString(3, usuario.getPassword());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
	
	//VALIDAR USUARIO
	public boolean validar(Usuario usuario)  throws SQLException{  
		
		boolean status=false;  
		try{  
		con.conectar();
		connection = con.getJdbcConnection();
		      
		PreparedStatement statement = connection.prepareStatement(  
		"SELECT * FROM usuario where usuario=? and password=?"); 
		statement.setString(1,usuario.getUsuario());  
		statement.setString(2,usuario.getPassword());  
		      
		ResultSet resulSet = statement.executeQuery();  
		status = resulSet.next();  
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
	}  
}
