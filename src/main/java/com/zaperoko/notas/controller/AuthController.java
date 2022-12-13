package com.zaperoko.notas.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaperoko.notas.model.Usuario;
import com.zaperoko.notas.service.UsuarioService;
import com.zaperoko.notas.util.JwtUtil;

@RestController
@RequestMapping("/api/autenticacion")
public class AuthController {

    @Autowired
    private UsuarioService servicio;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> verificarUsuario(@RequestBody Usuario user) {
        Optional<Usuario> resultado = servicio.verificarUsuario(user.getUsuario(), user.getClave());
        // return ResponseEntity.ok(resultado);
        if (!resultado.isPresent()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else {
            String token = jwtUtil.generarToken(user.getUsuario(), user.getIdRol());
            System.out.println("Arrieta "+token);
            return ResponseEntity.ok((new JSONObject().put("token", token)).toString());
        }
    }

}
