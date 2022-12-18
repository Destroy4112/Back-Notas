package com.zaperoko.notas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProfesorAsignatura {
    
    @Id
    private String id;
    private String profesorId;
    private String asignaturaId;
    private String idCurso;
    
	public ProfesorAsignatura() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(String profesorId) {
		this.profesorId = profesorId;
	}

	public String getAsignaturaId() {
		return asignaturaId;
	}

	public void setAsignaturaId(String asignaturaId) {
		this.asignaturaId = asignaturaId;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
    
    
}
