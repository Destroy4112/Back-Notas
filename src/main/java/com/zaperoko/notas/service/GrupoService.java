package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.Curso;
import com.zaperoko.notas.model.Grupo;
import com.zaperoko.notas.repository.CursosRepository;
import com.zaperoko.notas.repository.GruposRepository;

@Service
public class GrupoService {

    @Autowired
    private GruposRepository repositorio;
    @Autowired
    private CursosRepository repositorioCurso;

    public Grupo addGrupo(Grupo grupo) {
        Optional<Grupo> grupoEncontrado = repositorio.findByDescripcion(grupo.getNombreGrupo());
        if (grupoEncontrado.isPresent()) {
            return grupoEncontrado.get();
        }
        return repositorio.insert(grupo);
    }

    public List<Grupo> getGrupos() {
        return repositorio.findAll();
    }

    public Optional<Grupo> getGrupo(String id) {
        return repositorio.findById(id);
    }

    public Grupo actualizarGrupos(Grupo grupo) {
        Optional<Grupo> grupoEncontrado = repositorio.findByDescripcion(grupo.getNombreGrupo());
        if (grupoEncontrado.isPresent()) {
            return grupoEncontrado.get();
        } else {
            return repositorio.save(grupo);
        }
    }

    public String deleteGrupo(String id) {
        Optional<Grupo> grupoEncontrado = repositorio.findById(id);
        if (grupoEncontrado.isPresent()) {
            Optional<Curso> grupoEnCurso = repositorioCurso.findByIdGrupo(grupoEncontrado.get().getId());
            if (grupoEnCurso.isPresent()) {
                grupoEnCurso.get().setIdCurso("");
                repositorioCurso.save(grupoEnCurso.get());
            }
            repositorio.deleteById(id);
            return "eliminado " + id;
        }
        return "No encontrado";
    }
}