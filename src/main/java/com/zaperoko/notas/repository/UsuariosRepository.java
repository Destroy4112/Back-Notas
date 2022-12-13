package com.zaperoko.notas.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zaperoko.notas.model.Usuario;

@Repository
public interface UsuariosRepository extends MongoRepository<Usuario, String>{
    
    public Optional<Usuario> findByUsuario(String usuario);

    @Query("{usuario:'?0', clave:'?1'}") 
    Optional<Usuario> login (String usuario, String clave);
}
