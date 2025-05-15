package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.RCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SCategoria {

    @Autowired
    private RCategoria rCategoria;

    public Categoria crearCategoria(Categoria categoria) {
        return rCategoria.save(categoria);
    }

    public Categoria actualizarCategoria(Categoria categoria) {
        return rCategoria.save(categoria);
    }

    public void eliminarCategoria(Integer idCategoria) {
        rCategoria.deleteById(idCategoria);
    }

    public List<Categoria> listarCategorias() {
        return rCategoria.findAll();
    }

    public Optional<Categoria> buscarCategoriaPorId(Integer idCategoria) {
        return rCategoria.findById(idCategoria);
    }
    
    public List<Categoria> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return rCategoria.findAll();
        }
        return rCategoria.findByNombreContainingIgnoreCase(nombre);
    }
}
