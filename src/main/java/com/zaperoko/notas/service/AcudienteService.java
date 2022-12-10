package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.Acudiente;
import com.zaperoko.notas.repository.AcudienteRepository;

@Service
public class AcudienteService {

    @Autowired
    private AcudienteRepository repositorio;

    public Acudiente addAcudiente(Acudiente acudiente) {    
        Optional<Acudiente> acudienteEncontrado = repositorio.findByNroDocumento(acudiente.getNroDocumento());     
        if(acudienteEncontrado.isPresent()){
            return acudienteEncontrado.get();
        }
        return repositorio.insert(acudiente);
    }

    public List<Acudiente> getAcudiente() {
        return repositorio.findAll();
    }

    public Optional<Acudiente> getByDocumento(String documento){
        return repositorio.findByNroDocumento(documento);
    }

}