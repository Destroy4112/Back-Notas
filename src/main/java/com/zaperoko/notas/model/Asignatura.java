package com.zaperoko.notas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Asignatura {
    @Id
    private String id;
    private String descripcionAsignatura;
    private String grado;

    private String nombreGrado;
    
    public Asignatura() {
    	
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcionAsignatura() {
		return descripcionAsignatura;
	}

	public void setDescripcionAsignatura(String descripcionAsignatura) {
		this.descripcionAsignatura = descripcionAsignatura;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getNombreGrado() {
		return nombreGrado;
	}

	public void setNombreGrado(String nombreGrado) {
		this.nombreGrado = nombreGrado;
	}
    
    
}