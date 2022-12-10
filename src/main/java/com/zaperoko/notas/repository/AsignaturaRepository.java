package com.zaperoko.notas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Asignatura;

@Repository
public interface AsignaturaRepository extends MongoRepository<Asignatura, String> {

    public Optional<Asignatura> findByDescripcionAsignatura(String descripcionAsignatura);

    public List<Asignatura> findByGrado(String grado);

    @Query("{descripcionAsignatura:'?0', grado:'?1'}") 
    public Optional<Asignatura> findByDescripcionAndGrado(String descripcionAsignatura, String grado);
}