package com.example.demo.service;

import com.example.demo.model.Rol;
import com.example.demo.repository.RRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SRol {

    @Autowired
    private RRol rRol;

    public Rol crearRol(Rol rol) {
        return rRol.save(rol);
    }

    public Rol actualizarRol(Rol rol) {
        return rRol.save(rol);
    }

    public void eliminarRol(Integer idRol) {
        rRol.deleteById(idRol);
    }

    public List<Rol> listarRoles() {
        return rRol.findAll();
    }

    public Optional<Rol> buscarRolPorId(Integer idRol) {
        return rRol.findById(idRol);
    }
}
