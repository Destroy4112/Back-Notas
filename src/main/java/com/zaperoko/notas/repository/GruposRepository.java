package com.zaperoko.notas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Grupo;

@Repository
public interface GruposRepository extends MongoRepository<Grupo, String>{
    
    @Query("{descripcion:'?0'}") 
    public Optional<Grupo> findByDescripcion(String descripcion);

    @Query("{ cursoId: { $in : ['?0'] } }")
    public Optional<Grupo> findByCurso(String id);
}