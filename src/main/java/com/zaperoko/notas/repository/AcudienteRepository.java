package com.zaperoko.notas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Acudiente;

@Repository
public interface AcudienteRepository extends MongoRepository<Acudiente, String> {
    public Optional<Acudiente> findByNroDocumento(String nroDocumento);

    @Query("{ idAlumno: { $in : ['?0'] } }")
    public Optional<Acudiente> findByEstudiante(String id);
}
