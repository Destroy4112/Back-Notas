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

import com.zaperoko.notas.model.Grado;
import com.zaperoko.notas.service.GradoService;

@RestController
@RequestMapping("/api/grados")
@CrossOrigin(origins = "*")
public class GradoController {
    
    @Autowired
    private GradoService servicio;

    @PostMapping
    public ResponseEntity<?> crearGrado(@RequestBody Grado grado) {
        Grado resultado = servicio.addGrado(grado);
        if(resultado != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado); 
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Algo salío mal");
    }

    @GetMapping
    public ResponseEntity<?> readGrupos() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getGrados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readGrupoById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getGradoById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateGrado(@RequestBody Grado grado) {
        Grado resultado = servicio.updateGrado(grado);
        if(resultado != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado); 
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Algo salío mal");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGradoById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.deleteGrado(id));
    }
}