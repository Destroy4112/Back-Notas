package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.AlumnoCurso;
import com.zaperoko.notas.model.Curso;
import com.zaperoko.notas.repository.AlumnoCursoRepository;
import com.zaperoko.notas.repository.CursosRepository;

@Service
public class AlumnoCursoService {

    @Autowired
    private AlumnoCursoRepository repositorio;
    @Autowired
    private CursosRepository repositorioCurso;

    public AlumnoCurso addAlumnoCurso(AlumnoCurso detalle) {
        Optional<AlumnoCurso> registroEncontrado = repositorio.findAlumnoCurso(detalle.getIdCurso(),
                detalle.getIdEstudiante());
        if (registroEncontrado.isPresent()) {
            return registroEncontrado.get();
        }
        Optional<AlumnoCurso> estudiante = repositorio.findByIdEstudiantes(detalle.getIdEstudiante());

        if (estudiante.isPresent()) {
            Optional<Curso> curso = repositorioCurso.findById(detalle.getIdCurso());
            if (curso.isPresent()) {
                return repositorio.save(detalle);
            }
        }
        return null;

    }

    public List<AlumnoCurso> getAlumnoCursos() {
        return repositorio.findAll();
    }

    public Optional<AlumnoCurso> getAlumnoCursosById(String id) {
        return repositorio.findById(id);
    }

    /*
     * public AlumnoCurso updateAlumnoCurso(AlumnoCurso actualizacion) {
     * Optional<AlumnoCurso> registroExistente =
     * repositorio.findById(actualizacion.getId());
     * if (registroExistente.isPresent()) {
     * Optional<Curso> cursoExistente =
     * repositorioCurso.findById(actualizacion.getIdcurso());
     * Optional<Estudiante> alumnoEncontrado =
     * repositorioAlumno.findById(actualizacion.getIdestudiantes());
     * if (cursoExistente.isPresent() && alumnoEncontrado.isPresent()) {
     * return repositorio.save(actualizacion);
     * }
     * return null;
     * }
     * return null;
     * }
     */

    public String deleteAlumnoCurso(String id) {
        Optional<AlumnoCurso> registroEncontrado = repositorio.findById(id);
        if (registroEncontrado.isPresent()) {
            repositorio.deleteById(id);
            return "Eliminado Correctamente";
        }
        return "No existe el id ingresado";
    }
}