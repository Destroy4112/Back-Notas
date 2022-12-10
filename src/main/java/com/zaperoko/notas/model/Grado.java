package com.zaperoko.notas.model;

import java.util.List;

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
public class Grado {

    @Id
    private String id;
    private String descripcionGrado;
    private List<String> cursoId;
    private List<String> asignaturaId;

}