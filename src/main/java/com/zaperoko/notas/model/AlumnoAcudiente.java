package com.zaperoko.notas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class AlumnoAcudiente {

	@Id
	private String idAlumno;
	private String idAcudiente;

	public AlumnoAcudiente() {
		super();
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getIdAcudiente() {
		return idAcudiente;
	}

	public void setIdAcudiente(String idAcudiente) {
		this.idAcudiente = idAcudiente;
	}

}