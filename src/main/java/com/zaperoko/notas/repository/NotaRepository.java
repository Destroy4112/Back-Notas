package com.zaperoko.notas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Nota;

@Repository
public interface NotaRepository extends MongoRepository<Nota, String> {

}