package com.zaperoko.notas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("curso")
public class Curso {

    @Id
    private String idCurso;
    private String idGrado;
    private String idGrupo;
    private String idYear;
    private String descripcionCurso;
    private List<String> alumnoCurso;
    private List<String> idProfesorAsignatura;

    public Curso() {
		super();
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public String getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(String idGrado) {
		this.idGrado = idGrado;
	}

	public String getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getIdYear() {
		return idYear;
	}

	public void setIdYear(String idYear) {
		this.idYear = idYear;
	}

	public String getDescripcionCurso() {
		return descripcionCurso;
	}

	public void setDescripcionCurso(String descripcionCurso) {
		this.descripcionCurso = descripcionCurso;
	}

	public List<String> getAlumnoCurso() {
		return alumnoCurso;
	}

	public void setAlumnoCurso(List<String> alumnoCurso) {
		this.alumnoCurso = alumnoCurso;
	}

	public List<String> getIdProfesorAsignatura() {
		return idProfesorAsignatura;
	}

	public void setIdProfesorAsignatura(List<String> idProfesorAsignatura) {
		this.idProfesorAsignatura = idProfesorAsignatura;
	}
    

}