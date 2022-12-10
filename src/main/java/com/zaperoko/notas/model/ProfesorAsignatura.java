package com.zaperoko.notas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfesorAsignatura {
    
    @Id
    private String id;
    private String profesorId;
    private String asignaturaId;
    private String idCurso;
}
