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

import com.zaperoko.notas.model.Year;
import com.zaperoko.notas.service.YearService;

@RestController
@RequestMapping("api/years")
@CrossOrigin(origins="*")
public class YearController {

    @Autowired
    private YearService servicio;

    @PostMapping
    public ResponseEntity<?> crearYear(@RequestBody Year year) {
        Year resultado = servicio.addYear(year);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salío mal");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarYears() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getYears());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarYearPorId(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getYearsById(id));
    }

    @PutMapping
    public ResponseEntity<?> actualizarYear(@RequestBody Year year) {
        Year resultado = servicio.updateYears(year);
        if (resultado == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salío mal");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteYearPorId(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.deleteYear(id));
    }
}