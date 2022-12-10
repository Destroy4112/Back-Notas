package com.zaperoko.notas.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("curso")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Curso {

    @Id
    private String idCurso;
    private String idGrado;
    private String idGrupo;
    private String idYear;
    private String descripcionCurso;
    private List<String> alumnoCurso;
    private List<String> idProfesorAsignatura;

}