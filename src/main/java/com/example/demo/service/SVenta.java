package com.example.demo.service;

import com.example.demo.model.Venta;
import com.example.demo.repository.RVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SVenta {

    @Autowired
    private RVenta rVenta;

    public Venta crearVenta(Venta venta) {
        return rVenta.save(venta);
    }

    public Venta actualizarVenta(Venta venta) {
        return rVenta.save(venta);
    }

    public void eliminarVenta(Integer idVenta) {
        rVenta.deleteById(idVenta);
    }

    public List<Venta> listarVentas() {
        return rVenta.findAll();
    }

    public Optional<Venta> buscarVentaPorId(Integer idVenta) {
        return rVenta.findById(idVenta);
    }
}
