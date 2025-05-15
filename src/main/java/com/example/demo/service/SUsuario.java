package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.RUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SUsuario {

    @Autowired
    private RUsuario rUsuario;

    public Usuario crearUsuario(Usuario usuario) {
        return rUsuario.save(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        return rUsuario.save(usuario);
    }

    public void eliminarUsuario(Integer idUsuario) {
        rUsuario.deleteById(idUsuario);
    }

    public List<Usuario> listarUsuarios() {
        return rUsuario.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Integer idUsuario) {
        return rUsuario.findById(idUsuario);
    }
}
