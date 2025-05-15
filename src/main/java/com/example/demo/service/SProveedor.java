package com.example.demo.service;

import com.example.demo.model.Proveedor;
import com.example.demo.repository.RProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SProveedor {

    @Autowired
    private RProveedor rProveedor;

    public Proveedor crearProveedor(Proveedor proveedor) {
        return rProveedor.save(proveedor);
    }

    public Proveedor actualizarProveedor(Proveedor proveedor) {
        return rProveedor.save(proveedor);
    }

    public void eliminarProveedor(Integer idProveedor) {
        rProveedor.deleteById(idProveedor);
    }

    public List<Proveedor> listarProveedores() {
        return rProveedor.findAll();
    }

    public Optional<Proveedor> buscarProveedorPorId(Integer idProveedor) {
        return rProveedor.findById(idProveedor);
    }
    
    public List<Proveedor> buscarProveedoresPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return rProveedor.findAll();
        }
        return rProveedor.findByNombreContainingIgnoreCase(nombre);
    }
}
