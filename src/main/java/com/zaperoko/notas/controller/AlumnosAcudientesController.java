package com.zaperoko.notas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaperoko.notas.model.AlumnoAcudiente;
import com.zaperoko.notas.service.AlumnoAcudienteService;

@RestController
@RequestMapping("/api/alumno_acudientes")
@CrossOrigin(origins="*")
public class AlumnosAcudientesController {
    
    @Autowired 
    private AlumnoAcudienteService servicio;

    @PostMapping
    public ResponseEntity<?> crearAlumnoAcudiente(@RequestBody AlumnoAcudiente detalle){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.addAlumnoAcudiente(detalle));
    }

    @GetMapping
    public ResponseEntity<?> consultarAlumnoAcudientes(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getAlumnoAcudientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarAlumnoAcudientePorId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getAlumnoAcudientesById(id));
    }
}