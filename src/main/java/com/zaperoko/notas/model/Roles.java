package com.zaperoko.notas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document("roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roles {
    
    @Id
    private String id;
    private String descripcionRol;

}
