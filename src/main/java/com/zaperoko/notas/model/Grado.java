package com.zaperoko.notas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Grado {

    @Id
    private String id;
    private String descripcionGrado;
    private List<String> cursoId;
    private List<String> asignaturaId;
    
	public Grado() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcionGrado() {
		return descripcionGrado;
	}

	public void setDescripcionGrado(String descripcionGrado) {
		this.descripcionGrado = descripcionGrado;
	}

	public List<String> getCursoId() {
		return cursoId;
	}

	public void setCursoId(List<String> cursoId) {
		this.cursoId = cursoId;
	}

	public List<String> getAsignaturaId() {
		return asignaturaId;
	}

	public void setAsignaturaId(List<String> asignaturaId) {
		this.asignaturaId = asignaturaId;
	}
    
    

}