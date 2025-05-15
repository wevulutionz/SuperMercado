package com.example.demo.service;

import com.example.demo.model.DetalleVenta;
import com.example.demo.repository.RDetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SDetalleVenta {

    @Autowired
    private RDetalleVenta rDetalleVenta;

    public DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta) {
        return rDetalleVenta.save(detalleVenta);
    }

    public DetalleVenta actualizarDetalleVenta(DetalleVenta detalleVenta) {
        return rDetalleVenta.save(detalleVenta);
    }

    public void eliminarDetalleVenta(Integer idDetalleVenta) {
        rDetalleVenta.deleteById(idDetalleVenta);
    }

    public List<DetalleVenta> listarDetalleVentas() {
        return rDetalleVenta.findAll();
    }

    public Optional<DetalleVenta> buscarDetalleVentaPorId(Integer idDetalleVenta) {
        return rDetalleVenta.findById(idDetalleVenta);
    }
}
