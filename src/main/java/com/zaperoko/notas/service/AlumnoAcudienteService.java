package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.AlumnoAcudiente;
import com.zaperoko.notas.repository.AlumnoAcudienteRepository;

@Service
public class AlumnoAcudienteService {

    @Autowired
    private AlumnoAcudienteRepository repositorio;

    public AlumnoAcudiente addAlumnoAcudiente(AlumnoAcudiente alumnoAcudiente) {
        return repositorio.insert(alumnoAcudiente);
    }

    public List<AlumnoAcudiente> getAlumnoAcudientes() {
        return repositorio.findAll();
    }

    public Optional<AlumnoAcudiente> getAlumnoAcudientesById(String id) {
        return repositorio.findByIdAlumno(id);
    }
}
