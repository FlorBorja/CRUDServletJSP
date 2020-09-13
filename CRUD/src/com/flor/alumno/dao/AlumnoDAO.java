package com.flor.alumno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flor.alumno.modelo.Alumno;
import com.flor.alumno.modelo.Conexion;


public class AlumnoDAO {

	private Conexion con;
	private Connection connection;
	
	public AlumnoDAO (String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	//INSERTAR ALUMNO
	public boolean insertar (Alumno alumno) throws SQLException{
		
		String sql = "INSERT INTO alumno (id, ncontrol, nombre, paterno, materno, curso, semestre) VALUES (?, ?, ?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setInt(2, alumno.getNcontrol());
		statement.setString(3, alumno.getNombre());
		statement.setString(4, alumno.getPaterno());
		statement.setString(5, alumno.getMaterno());
		statement.setString(6, alumno.getCurso());
		statement.setInt(7, alumno.getSemestre());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}
	
	//MOTRAR TODOS LOS ALUMNOS
	public List<Alumno> listarAlumnos() throws SQLException {
	
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		String sql = "SELECT * FROM alumno";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		
		while(resulSet.next()) {
			int id = resulSet.getInt("id");
			int ncontrol = resulSet.getInt("ncontrol");
			String nombre = resulSet.getString("nombre");
			String paterno = resulSet.getString("paterno");
			String materno = resulSet.getString("materno");
			String curso = resulSet.getString("curso");
			int semestre = resulSet.getInt("semestre");
			Alumno alumno = new Alumno(id, ncontrol, nombre, paterno, materno, curso, semestre);
			listaAlumnos.add(alumno);
		}
		con.desconectar();
		return listaAlumnos;	
	}
	
	//OBTENER POR ID
	public Alumno obtenerID(int id) throws SQLException {
		
		Alumno alumno = null;
		
		String sql = "SELECT * FROM alumno WHERE id= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet res = statement.executeQuery();
		if(res.next()) {
			alumno = new Alumno(res.getInt("id"), res.getInt("ncontrol"), res.getString("nombre"), 
					res.getString("paterno"), res.getString("materno"), res.getString("curso"), res.getInt("semestre"));
		}
		res.close();
		con.desconectar();
		
		return alumno;
	}
	
	//ACTUALIZAR
	public boolean actualizar(Alumno alumno) throws SQLException {
		
		boolean rowActualizar = false;
		String sql = "UPDATE alumno SET ncontrol=?,nombre=?,paterno=?,materno=?,curso=?,semestre=? WHERE id= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, alumno.getNcontrol());
		statement.setString(2, alumno.getNombre());
		statement.setString(3, alumno.getPaterno());
		statement.setString(4, alumno.getMaterno());
		statement.setString(5, alumno.getCurso());
		statement.setInt(6, alumno.getSemestre());
		statement.setInt(7, alumno.getId());
		
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//ELIMINAR
	public boolean eliminar(Alumno alumno) throws SQLException {
		
		boolean rowEliminar = false;
		String sql = "DELETE FROM alumno WHERE ID=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, alumno.getId());
		
		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowEliminar;
	}
	
}
