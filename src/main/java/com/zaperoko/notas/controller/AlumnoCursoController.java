package com.zaperoko.notas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaperoko.notas.model.AlumnoCurso;
import com.zaperoko.notas.service.AlumnoCursoService;

@RestController
@RequestMapping("api/alumno_curso")
@CrossOrigin(origins="*")
public class AlumnoCursoController {

    @Autowired
    private AlumnoCursoService servicio;

    @PostMapping
    public ResponseEntity<?> crearAlumnoCurso(@RequestBody AlumnoCurso detalle) {
        AlumnoCurso response = servicio.addAlumnoCurso(detalle);

        if (response == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salío mal");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<?> consultarAlumnoCursos() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getAlumnoCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarAlumnoCursoPorId(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getAlumnoCursosById(id));
    }

    /*
     * @PutMapping
     * public ResponseEntity<?> actualizarAlumnoCurso(@RequestBody AlumnoCurso
     * alumnoCurso) {
     * AlumnoCurso response = servicio.updateAlumnoCurso(alumnoCurso);
     * if (response == null) {
     * return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salío mal");
     * }
     * return ResponseEntity.status(HttpStatus.CREATED).body(response);
     * }
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarAlumnoCurso(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.deleteAlumnoCurso(id));
    }
}