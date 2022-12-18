package com.zaperoko.notas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Year {

    @Id
    private String id;
    private String descripcionYear;
    private List<String> curso;
    
	public Year() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcionYear() {
		return descripcionYear;
	}

	public void setDescripcionYear(String descripcionYear) {
		this.descripcionYear = descripcionYear;
	}

	public List<String> getCurso() {
		return curso;
	}

	public void setCurso(List<String> curso) {
		this.curso = curso;
	}
    
    
    
}