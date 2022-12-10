package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.Asignatura;
import com.zaperoko.notas.model.Docente;
import com.zaperoko.notas.model.ProfesorAsignatura;
import com.zaperoko.notas.repository.AsignaturaRepository;
import com.zaperoko.notas.repository.DocenteRepository;
import com.zaperoko.notas.repository.ProfesorAsignaturaRepository;

@Service
public class ProfesorAsignaturaService {

    @Autowired
    private ProfesorAsignaturaRepository repositorio;
    @Autowired
    private AsignaturaRepository asignaturaRepositorio;
    @Autowired
    private DocenteRepository docenteRepositorio;

    public ProfesorAsignatura addProfesorAsignatura(ProfesorAsignatura profesorAsignatura) {
        Optional<ProfesorAsignatura> validacion = repositorio
                .findProfesorAsignatura(profesorAsignatura.getAsignaturaId(), profesorAsignatura.getProfesorId());
        Optional<Docente> docenteList = docenteRepositorio.findById(profesorAsignatura.getProfesorId());
        Optional<Asignatura> asignaturaList = asignaturaRepositorio.findById(profesorAsignatura.getAsignaturaId());
        if (validacion.isPresent()) {
            return validacion.get();
        }
        if (docenteList.isPresent() && asignaturaList.isPresent()) {
            return repositorio.insert(profesorAsignatura);
        }
        return null;
    }

    public List<ProfesorAsignatura> getProfesoresAsignaturas() {
        return repositorio.findAll();
    }

    public List<ProfesorAsignatura> getByProfesor(String idProfesor) {
        return repositorio.findByProfesorId(idProfesor);
    }

    public ProfesorAsignatura actualizarProfesorAsignatura(ProfesorAsignatura profesorAsignatura) {
        Optional<ProfesorAsignatura> validacion = repositorio
                .findProfesorAsignatura(profesorAsignatura.getAsignaturaId(), profesorAsignatura.getProfesorId());
        if (validacion.isPresent()) {
            return validacion.get();
        }
        Optional<Docente> docenteList = docenteRepositorio.findById(profesorAsignatura.getProfesorId());
        Optional<Asignatura> asignaturaList = asignaturaRepositorio.findById(profesorAsignatura.getAsignaturaId());
        if (docenteList.isPresent() && asignaturaList.isPresent()) {
            return repositorio.save(profesorAsignatura);
        }
        return null;
    }

    public String deleteProfesorAsignatura(String id) {
        Optional<ProfesorAsignatura> profesorAsignatura = repositorio.findById(id);
        if (profesorAsignatura.isPresent()) {
            repositorio.delete(profesorAsignatura.get());
            return "Eliminado Correctamente";
        }
        return "No existe ninguna asignatura-docente con ese id";
    }

}
