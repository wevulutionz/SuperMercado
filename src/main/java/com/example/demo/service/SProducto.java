package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.RProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SProducto {

    @Autowired
    private RProducto rProducto;

    public Producto crearProducto(Producto producto) {
        return rProducto.save(producto);
    }

    public Producto actualizarProducto(Producto producto) {
        return rProducto.save(producto);
    }

    public void eliminarProducto(Integer idProducto) {
        rProducto.deleteById(idProducto);
    }

    public List<Producto> listarProductos() {
        return rProducto.findAll();
    }

    public Optional<Producto> buscarProductoPorId(Integer idProducto) {
        return rProducto.findById(idProducto);
    }

    public List<Producto> buscarProductosConFiltros(String nombre, Integer categoriaId, Integer proveedorId) {
        return rProducto.buscarProductosConFiltros(nombre, categoriaId, proveedorId);
    }
}
