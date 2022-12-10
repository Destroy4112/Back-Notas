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

import com.zaperoko.notas.model.Estudiante;
import com.zaperoko.notas.service.EstudianteService;

@RestController
@RequestMapping("api/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteController {
    
    @Autowired
    private EstudianteService servicio;

    @PostMapping
    public ResponseEntity<?> crearEstudiante(@RequestBody Estudiante estudiante){
        Estudiante resultado = servicio.addEstudiante(estudiante);
        if(resultado == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salio mal");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
    }

    @GetMapping
    public ResponseEntity<?> consultarEstudiantes(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getEstudiantes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarEstudiantePorId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getlista(id));
    }

    @PutMapping
    public ResponseEntity<?> actualizarEstudiante(@RequestBody Estudiante estudiante){
        Estudiante resultado = servicio.updateEstudiante(estudiante);
        if(resultado == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo salio mal");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.deleteEstudiante(id));
    }
 
}
