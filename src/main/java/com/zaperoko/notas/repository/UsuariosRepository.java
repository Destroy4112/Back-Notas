package com.zaperoko.notas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Usuario;

@Repository
public interface UsuariosRepository extends MongoRepository<Usuario, String>{
    
    public Optional<Usuario> findByUsuario(String usuario);
}
