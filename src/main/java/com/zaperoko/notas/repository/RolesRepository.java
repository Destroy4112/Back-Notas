package com.zaperoko.notas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Roles;

@Repository
public interface RolesRepository extends MongoRepository<Roles, String> {
    
    public Optional<Roles> findByDescripcionRol(String descripcionRol);
}
