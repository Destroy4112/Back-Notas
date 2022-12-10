package com.zaperoko.notas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Estudiante;

@Repository
public interface EstudianteRepository extends MongoRepository<Estudiante, String>{
    
    public Optional<Estudiante> findByNumeroDocumento(String numeroDocumento);
}
