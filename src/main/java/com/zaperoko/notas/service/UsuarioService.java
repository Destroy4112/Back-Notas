package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.Usuario;
import com.zaperoko.notas.repository.UsuariosRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuariosRepository repositorio;

    public List<Usuario> getUsuarios(){
        return repositorio.findAll();
    }

    public Optional<Usuario> getUsuariosById(String id){
        return repositorio.findById(id);
    }
}
