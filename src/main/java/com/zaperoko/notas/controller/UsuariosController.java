package com.zaperoko.notas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaperoko.notas.model.Usuario;
import com.zaperoko.notas.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins="*")
public class UsuariosController {

    @Autowired
    private UsuarioService servicio;

    @GetMapping
    public ResponseEntity<?> consultarUsuarios() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getUsuarios());
    }

    @PostMapping
    public ResponseEntity<?> consultarUsuarioPorId(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.verificarUsuario(usuario.getUsuario(),usuario.getClave()));
    }
}