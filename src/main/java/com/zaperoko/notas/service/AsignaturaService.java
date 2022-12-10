package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.Asignatura;
import com.zaperoko.notas.model.Grado;
import com.zaperoko.notas.model.ProfesorAsignatura;
import com.zaperoko.notas.repository.AsignaturaRepository;
import com.zaperoko.notas.repository.GradoRepository;
import com.zaperoko.notas.repository.ProfesorAsignaturaRepository;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository repositorio;
    @Autowired
    private GradoRepository repositorioGrado;
    @Autowired
    private ProfesorAsignaturaRepository repositorioProfesor;

    public Asignatura crearAsignatura(Asignatura asignatura) {
        Optional<Asignatura> asignaturaEncontrada = repositorio
                .findByDescripcionAndGrado(asignatura.getDescripcionAsignatura(), asignatura.getGrado());
        if (asignaturaEncontrada.isPresent()) {
            return asignaturaEncontrada.get();
        }
        Optional<Grado> busquedaGrado = repositorioGrado.findById(asignatura.getGrado());
        if (busquedaGrado.isPresent()) {
            return repositorio.insert(asignatura);
        }
        return null;
    }

    public List<Asignatura> obtenerAsignaturas() {
        List<Asignatura> asignaturas = repositorio.findAll();
        for (int i = 0; i < asignaturas.size(); i++) {
            asignaturas.get(i).setNombreGrado(repositorioGrado.findById(asignaturas.get(i).getGrado()).get().getDescripcionGrado());
        }
        return asignaturas;
    }

    public Optional<Asignatura> getAsignaturaById(String id) {
        return repositorio.findById(id);
    }

    public Asignatura actualizarAsignaturas(Asignatura asignatura) {
        Optional<Grado> busquedaGrado = repositorioGrado.findById(asignatura.getGrado());
        Optional<Asignatura> asignaturaEncontrada = repositorio
                .findByDescripcionAndGrado(asignatura.getDescripcionAsignatura(), asignatura.getGrado());
        if (asignaturaEncontrada.isPresent()) {
            return asignaturaEncontrada.get();
        }
        Optional<Asignatura> descripcion = repositorio
                .findByDescripcionAsignatura(asignatura.getDescripcionAsignatura());
        if (descripcion.isPresent() && descripcion.get().getId().equals(asignatura.getId())) {
            if (busquedaGrado.isPresent()) {
                return repositorio.save(asignatura);
            }
            return null;
        }
        if (busquedaGrado.isPresent()) {
            return repositorio.save(asignatura);
        }
        return null;
    }

    public String deleteAsignatura(String id) {
        Optional<Asignatura> asignaturaEncontrada = repositorio.findById(id);
        if (asignaturaEncontrada.isPresent()) {
            List<ProfesorAsignatura> busqueda = repositorioProfesor.findByAsignaturaId(id);
            if (busqueda.size() > 0) {
                for (int i = 0; i < busqueda.size(); i++) {
                    repositorioProfesor.delete(busqueda.get(i));
                }
            }
            repositorio.delete(asignaturaEncontrada.get());
            return "eliminado " + id;
        }
        return "No encontrado";
    }
}