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

import com.zaperoko.notas.model.Docente;
import com.zaperoko.notas.service.DocenteService;

@RestController
@RequestMapping("api/docentes")
@CrossOrigin(origins = "*")
public class DocentesController {
    
    @Autowired
    private DocenteService docenteServicio;

    @PostMapping
    public ResponseEntity<?> crearDocente(@RequestBody Docente docente){
        Docente resultado = docenteServicio.addDocente(docente);
        if(resultado == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
    }

    @GetMapping
    public ResponseEntity<?> consultarDocentes(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(docenteServicio.getConsultarDocentes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarDocentePorId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(docenteServicio.getDocenteById(id));
    }

    @PutMapping
    public ResponseEntity<?> actualizarDocente(@RequestBody Docente docente){
        Docente resultado = docenteServicio.updateDocente(docente);
        if(resultado == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hay campos vacios");
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDocente(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(docenteServicio.deleteDocente(id));
    }
}