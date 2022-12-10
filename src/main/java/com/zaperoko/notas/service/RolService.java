package com.zaperoko.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaperoko.notas.model.Docente;
import com.zaperoko.notas.model.Roles;
import com.zaperoko.notas.repository.DocenteRepository;
import com.zaperoko.notas.repository.RolesRepository;

@Service
public class RolService {

    @Autowired
    private RolesRepository repositorio;
    @Autowired
    private DocenteRepository repositorioDocente;

    public Roles addRol(Roles rol) {
        Optional<Roles> roles = repositorio.findByDescripcionRol(rol.getDescripcionRol());
        if (roles.isPresent()) {
            return roles.get();
        }
        return repositorio.insert(rol);
    }

    public List<Roles> getRoles() {
        return repositorio.findAll();
    }

    public Optional<Roles> getRolesByDescripcion(String descripcion) {
        return repositorio.findByDescripcionRol(descripcion);
    }

    public Optional<Roles> getRolById(String id) {
        return repositorio.findById(id);
    }

    public Roles updateRoles(Roles rol) {
        Optional<Roles> resultado = repositorio.findByDescripcionRol(rol.getDescripcionRol());
        if (resultado.isPresent()) {
            return resultado.get();
        }
        Optional<Roles> roles = repositorio.findById(rol.getId());
        if (roles.isPresent()) {
            return repositorio.save(rol);
        }
        return null;
    }

    public String deleteRol(String id) {
        Optional<Roles> roles = repositorio.findById(id);
        if (roles.isPresent()) {
            List<Docente> docentes = repositorioDocente.findByIdRol(id);
            if (docentes.size() > 0) {
                for (int i=0; i < docentes.size(); i++) {
                    repositorioDocente.delete(docentes.get(i));
                }
            }
            repositorio.delete(roles.get());
            return "Eliminado Correctamente";
        }
        return "No existe ningun rol con ese id";
    }
}
