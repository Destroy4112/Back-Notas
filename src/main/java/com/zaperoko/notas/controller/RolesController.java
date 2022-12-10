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

import com.zaperoko.notas.model.Roles;
import com.zaperoko.notas.service.RolService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolesController {

	@Autowired
	private RolService servicio;

	@PostMapping
	public ResponseEntity<?> agregarRol(@RequestBody Roles rol) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.addRol(rol));
	}

	@GetMapping
	public ResponseEntity<?> consultarRoles() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getRoles());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarRolPorId(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.getRolById(id));
	}

	@PutMapping
	public ResponseEntity<?> actualizarRol(@RequestBody Roles rol) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.updateRoles(rol));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRolPorId(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(servicio.deleteRol(id));
	}

}
