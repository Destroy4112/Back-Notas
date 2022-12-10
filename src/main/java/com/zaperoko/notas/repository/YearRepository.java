package com.zaperoko.notas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Year;

@Repository
public interface YearRepository extends MongoRepository<Year, String>{
    
    public Optional<Year> findBydescripcionYear(String descripcionYear);

    @Query("{ cursoId: { $in : ['?0'] } }")
    public Optional<Year> findByCurso(String id);
}