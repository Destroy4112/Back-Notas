package com.zaperoko.notas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.AlumnoAcudiente;

@Repository
public interface AlumnoAcudienteRepository extends MongoRepository<AlumnoAcudiente, String>{
    public Optional<AlumnoAcudiente> findByIdAlumno(String idAlumno);
}
