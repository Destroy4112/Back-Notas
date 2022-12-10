package com.zaperoko.notas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaperoko.notas.model.Grupo;
import com.zaperoko.notas.service.GrupoService;

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin("*")
public class GruposController {
    @Autowired
    private GrupoService servicio;

    @PostMapping
    public ResponseEntity<?> agregarGrupo(@RequestBody Grupo grupo) {
        Grupo resultado = servicio.addGrupo(grupo);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salio mal");
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarGrupos() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getGrupos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarGrupoById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getGrupo(id));
    }

    @PutMapping
    public ResponseEntity<?> updateGrupo(@RequestBody Grupo grupo) {
        Grupo resultado = servicio.actualizarGrupos(grupo);
        if(resultado != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado); 
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salío mal");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGrupoById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.deleteGrupo(id));
    }

}