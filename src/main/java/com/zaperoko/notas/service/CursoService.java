package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.AlumnoCurso;
import com.zaperoko.notas.model.Curso;
import com.zaperoko.notas.model.Grado;
import com.zaperoko.notas.model.Grupo;
import com.zaperoko.notas.model.ProfesorAsignatura;
import com.zaperoko.notas.model.Year;
import com.zaperoko.notas.repository.AlumnoCursoRepository;
import com.zaperoko.notas.repository.CursosRepository;
import com.zaperoko.notas.repository.GradoRepository;
import com.zaperoko.notas.repository.GruposRepository;
import com.zaperoko.notas.repository.ProfesorAsignaturaRepository;
import com.zaperoko.notas.repository.YearRepository;

@Service
public class CursoService {

    @Autowired
    private CursosRepository repositorio;
    @Autowired
    private GruposRepository grupoRepositorio;
    @Autowired
    private GradoRepository gradoRepositorio;
    @Autowired
    private YearRepository yearRepositorio;
    @Autowired
    private AlumnoCursoRepository repositorioAlumnoCurso;
    @Autowired
    private ProfesorAsignaturaRepository repositorioProfesorAsignatura;

    public Curso addCurso(Curso curso) {
        Optional<Curso> busquedaCurso = repositorio.findByDescripcionCurso(curso.getDescripcionCurso());
        if (busquedaCurso.isPresent()) {
            return busquedaCurso.get();
        }
        Optional<Curso> validacion = repositorio.buscarCurso(curso.getIdGrado(), curso.getIdGrupo(), curso.getIdYear());
        if (validacion.isPresent()) {
            return validacion.get();
        }
        Optional<Grupo> grupoEncontrado = grupoRepositorio.findById(curso.getIdGrupo());
        Optional<Grado> gradoExiste = gradoRepositorio.findById(curso.getIdGrado());
        Optional<Year> yearEncontrado = yearRepositorio.findById(curso.getIdYear());
        if (gradoExiste.isPresent() && yearEncontrado.isPresent() && grupoEncontrado.isPresent()) {
            Curso cursoCreado = repositorio.insert(curso);
            grupoEncontrado.get().getCursoId().add(cursoCreado.getIdCurso());
            grupoRepositorio.save(grupoEncontrado.get());
            gradoExiste.get().getCursoId().add(cursoCreado.getIdCurso());
            gradoRepositorio.save(gradoExiste.get());
            yearEncontrado.get().getCurso().add(cursoCreado.getIdCurso());
            yearRepositorio.save(yearEncontrado.get());
            return cursoCreado;
        }
        return null;
    }

    public List<Curso> getCursos() {
        return repositorio.findAll();
    }

    public Optional<Curso> getCursosById(String id) {
        return repositorio.findById(id);
    }

    public Curso updateCurso(Curso curso) {
        Optional<Curso> busquedaCurso = repositorio.findByDescripcionCurso(curso.getDescripcionCurso());
        Optional<Grupo> busquedaGrupo = grupoRepositorio.findById(curso.getIdGrupo());
        Optional<Grado> busquedaGrado = gradoRepositorio.findById(curso.getIdGrado());
        Optional<Year> busquedaYear = yearRepositorio.findById(curso.getIdYear());
        Optional<Curso> validacion = repositorio.buscarCurso(curso.getIdGrado(), curso.getIdGrupo(), curso.getIdYear());
        if (busquedaCurso.isPresent() && busquedaCurso.get().getIdCurso().equals(curso.getIdCurso())) {
            if (busquedaGrado.isPresent() && busquedaYear.isPresent() && busquedaGrupo.isPresent()) {
                if (validacion.isPresent()) {
                    return validacion.get();
                }
                return repositorio.save(curso);
            }
            return null;
        }
        if (busquedaCurso.isPresent()) {
            return busquedaCurso.get();
        }

        if (validacion.isPresent()) {
            return validacion.get();
        }

        if (busquedaCurso.isPresent() && busquedaCurso.get().getIdCurso() == curso.getIdCurso()) {
            if (busquedaGrado.isPresent() && busquedaYear.isPresent() && busquedaGrupo.isPresent()) {
                if (validacion.isPresent()) {
                    return validacion.get();
                }
                return repositorio.save(curso);
            }
            return null;
        }

        if (busquedaGrado.isPresent() && busquedaYear.isPresent() && busquedaGrupo.isPresent()) {
            return repositorio.insert(curso);
        }
        return null;
    }

    public String deleteCurso(String descripcionCurso, String descripcionYear) {
        Optional<Year> year = yearRepositorio.findBydescripcionYear(descripcionYear);
        if (year.isPresent()) {
            Optional<Curso> curso = repositorio.findCursoByDescripcion(descripcionCurso, year.get().getId());
            if (curso.isPresent()) {
                Optional<Grado> cursoEnGrado = gradoRepositorio.findByCurso(curso.get().getIdCurso());
                if (cursoEnGrado.isPresent()) {
                    int longitud = cursoEnGrado.get().getCursoId().size();
                    for (int i = 0; i < longitud; i++) {
                        String idCurso = cursoEnGrado.get().getCursoId().get(i);
                        if (idCurso.equals(curso.get().getIdCurso())) {
                            cursoEnGrado.get().getCursoId().remove(i);
                        }
                    }
                    gradoRepositorio.save(cursoEnGrado.get());
                }
                Optional<Grupo> cursoEnGrupo = grupoRepositorio.findByCurso(curso.get().getIdCurso());
                if (cursoEnGrupo.isPresent()) {
                    int longitud = cursoEnGrupo.get().getCursoId().size();
                    for (int i = 0; i < longitud; i++) {
                        String idCurso = cursoEnGrupo.get().getCursoId().get(i);
                        if (idCurso.equals(curso.get().getIdCurso())) {
                            cursoEnGrupo.get().getCursoId().remove(i);
                        }
                    }
                    grupoRepositorio.save(cursoEnGrupo.get());
                }
                Optional<AlumnoCurso> cursoEncontrado = repositorioAlumnoCurso.findByCurso(curso.get().getIdCurso());
                if (cursoEncontrado.isPresent()) {
                    // cursoEncontrado.get().setIdcurso("");
                    repositorioAlumnoCurso.save(cursoEncontrado.get());
                }
                Optional<ProfesorAsignatura> cursoEnProfesorAsignatura = repositorioProfesorAsignatura
                        .findByIdCurso(curso.get().getIdCurso());
                if (cursoEnProfesorAsignatura.isPresent()) {
                    cursoEnProfesorAsignatura.get().setIdCurso("");
                    repositorioProfesorAsignatura.save(cursoEnProfesorAsignatura.get());
                }
                Optional<Year> cursoEnYear = yearRepositorio.findByCurso(curso.get().getIdCurso());
                if (cursoEnYear.isPresent()) {
                    int longitud = cursoEnYear.get().getCurso().size();
                    for (int i = 0; i < longitud; i++) {
                        String idCurso = cursoEnYear.get().getCurso().get(i);
                        if (idCurso.equals(curso.get().getIdCurso())) {
                            cursoEnYear.get().getCurso().remove(i);
                            break;
                        }
                    }
                    yearRepositorio.save(cursoEnYear.get());
                }
                repositorio.deleteById(curso.get().getIdCurso());
                return "Eliminado correctamente";
            }

        }
        return "No existe el curso ingresado";
    }
}