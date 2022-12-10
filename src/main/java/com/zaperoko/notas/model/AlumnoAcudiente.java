package com.zaperoko.notas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlumnoAcudiente {

    @Id
    private String idAlumno;
    private String idAcudiente;
}