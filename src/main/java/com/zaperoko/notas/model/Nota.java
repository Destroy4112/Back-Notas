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
public class Nota {
    @Id
    private String id;
    private String nota1;
    private String nota2;
    private String nota3;
    private String nota4;
    private String promedio;
    private String estado;
    private String idAlumnoCurso;
    private String idAsignatura;
}