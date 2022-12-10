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

import com.zaperoko.notas.model.Asignatura;
import com.zaperoko.notas.service.AsignaturaService;

@RestController
@RequestMapping("/api/asignaturas")
@CrossOrigin(origins = "*")
public class AsignaturaController {
    @Autowired
    private AsignaturaService servicio;

    @PostMapping
    public ResponseEntity<?> createAsinatura(@RequestBody Asignatura asignatura) {
        Asignatura resultado = servicio.crearAsignatura(asignatura);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Algo salío mal");
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
        }
    }

    @GetMapping
    public ResponseEntity<?> readAsignaturas() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.obtenerAsignaturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readGrupoById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getAsignaturaById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateGrado(@RequestBody Asignatura asignatura) {
        Asignatura resultado = servicio.actualizarAsignaturas(asignatura);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Algo salío mal");
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGradoById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.deleteAsignatura(id));
    }
}