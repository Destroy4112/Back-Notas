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

import com.zaperoko.notas.model.Curso;
import com.zaperoko.notas.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class CursosController {

    @Autowired
    private CursoService servicio;

    @PostMapping
    public ResponseEntity<?> crearCurso(@RequestBody Curso curso) {
        Curso resultado = servicio.addCurso(curso);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salío mal");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping
    public ResponseEntity<?> consultarCursos() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarCursoPorId(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getCursosById(id));
    }

    @PutMapping
    public ResponseEntity<?> actualizarCurso(@RequestBody Curso curso) {
        Curso resultado = servicio.updateCurso(curso);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salío mal");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @DeleteMapping("/{id}/{year}")
    public ResponseEntity<?> eliminarCurso(@PathVariable String id, @PathVariable String year) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.deleteCurso(id, year));
    }
}