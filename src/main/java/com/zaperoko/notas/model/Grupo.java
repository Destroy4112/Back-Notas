package com.zaperoko.notas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Grupo {

    @Id
    private String id;
    private String nombreGrupo;
    private List<String> cursoId;
    
	public Grupo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public List<String> getCursoId() {
		return cursoId;
	}

	public void setCursoId(List<String> cursoId) {
		this.cursoId = cursoId;
	}
    
    

}