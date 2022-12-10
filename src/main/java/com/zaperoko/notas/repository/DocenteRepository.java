package com.zaperoko.notas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Docente;

@Repository
public interface DocenteRepository extends MongoRepository<Docente, String> {

    public Optional<Docente> findByNumeroDocumento(String numeroDocumento);

    @Query("{ id:?0, numeroDocumento:'?1' }")
    public Optional<Docente> findByIdAndDocumento(String id, String documento);

    public List<Docente> findByIdRol(String idRol);
}