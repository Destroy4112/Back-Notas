package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.Asignatura;
import com.zaperoko.notas.model.Curso;
import com.zaperoko.notas.model.Grado;
import com.zaperoko.notas.repository.AsignaturaRepository;
import com.zaperoko.notas.repository.CursosRepository;
import com.zaperoko.notas.repository.GradoRepository;

@Service
public class GradoService {

    @Autowired
    private GradoRepository repositorio;
    @Autowired
    private AsignaturaRepository asignaturaRepositorio;
    @Autowired
    private CursosRepository RepositorioCurso;

    public Grado addGrado(Grado grado) {
        Optional<Grado> gradoEncontrado = repositorio.findByDescripcionGrado(grado.getDescripcionGrado());
        if (gradoEncontrado.isPresent()) {
            return gradoEncontrado.get();
        }
        return repositorio.insert(grado);
    }

    public List<Grado> getGrados() {
        return repositorio.findAll();
    }

    public Optional<Grado> getGradoById(String id) {
        return repositorio.findById(id);
    }

    public Grado updateGrado(Grado grado) {
        Optional<Grado> gradoEncontrado = repositorio.findByDescripcionGrado(grado.getDescripcionGrado());
        if (gradoEncontrado.isPresent()) {
            return gradoEncontrado.get();
        }
        return repositorio.save(grado);
    }

    public String deleteGrado(String id) {
        Optional<Grado> gradoEncontrado = repositorio.findById(id);
        if (gradoEncontrado.isPresent()) {
            List<Asignatura> listaAsignaturas = asignaturaRepositorio.findByGrado(gradoEncontrado.get().getId());
            if (listaAsignaturas.size() > 0) {
                for (int i = 0; i < listaAsignaturas.size(); i++) {
                    asignaturaRepositorio.delete(listaAsignaturas.get(i));
                }
            }
            List<Curso> listaCursos = RepositorioCurso.findByIdGrado(gradoEncontrado.get().getId());
            if (listaCursos.size() > 0) {
                for (int i = 0; i < listaCursos.size(); i++) {
                    listaCursos.get(i).setIdGrado("");
                }
                RepositorioCurso.saveAll(listaCursos);
            }
            repositorio.deleteById(id);
            return "eliminado correctamente";
        }
        return "No encontrado";
    }
}