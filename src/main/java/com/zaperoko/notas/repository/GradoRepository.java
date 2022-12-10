package com.zaperoko.notas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Grado;

@Repository
public interface GradoRepository extends MongoRepository<Grado, String> {
    
    public Optional<Grado> findByDescripcionGrado(String descripcionGrado);

    @Query("{ cursoId: { $in : ['?0'] } }")
    public Optional<Grado> findByCurso(String id);
}