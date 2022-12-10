package com.zaperoko.notas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.ProfesorAsignatura;

@Repository
public interface ProfesorAsignaturaRepository extends MongoRepository<ProfesorAsignatura, String> {

    public List<ProfesorAsignatura> findByProfesorId(String profesorId);

    public List<ProfesorAsignatura> findByAsignaturaId(String asignaturaId);

    @Query("{profesorId:'?0', asignaturaId:'?1'}")
    public Optional<ProfesorAsignatura> findProfesorAsignatura(String profesorId, String asignaturaId);

    public Optional<ProfesorAsignatura> findByIdCurso(String idCurso);
}