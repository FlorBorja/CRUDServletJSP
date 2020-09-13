package com.flor.alumno.modelo;

public class Alumno {
	private int id;
	private int ncontrol;
	private String nombre;
	private String paterno;
	private String materno;
	private String curso;
	private int semestre;
	
	public Alumno(int id, int ncontrol, String nombre, String paterno, String materno, String curso, int semestre) {
		this.id = id;
		this.ncontrol = ncontrol;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.curso = curso;
		this.semestre = semestre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNcontrol() {
		return ncontrol;
	}

	public void setNcontrol(int ncontrol) {
		this.ncontrol = ncontrol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
}
