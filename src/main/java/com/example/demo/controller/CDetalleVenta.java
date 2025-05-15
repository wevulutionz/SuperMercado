package com.example.demo.controller;

import com.example.demo.model.DetalleVenta;
import com.example.demo.service.SDetalleVenta;
import com.example.demo.service.SProducto;
import com.example.demo.service.SVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalleventa")
public class CDetalleVenta {

    @Autowired
    private SDetalleVenta sDetalleVenta;

    @Autowired
    private SProducto sProducto;

    @Autowired
    private SVenta sVenta;

    @GetMapping("/listar")
    public String listarDetalleVentas(Model model) {
        model.addAttribute("detalleVentas", sDetalleVenta.listarDetalleVentas());
        return "detalleventa/listar";
    }

    @GetMapping("/nuevo")
    public String nuevoDetalleVenta(Model model) {
        model.addAttribute("detalleVenta", new DetalleVenta());
        model.addAttribute("productos", sProducto.listarProductos());
        model.addAttribute("ventas", sVenta.listarVentas());
        return "detalleventa/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarDetalleVenta(@ModelAttribute DetalleVenta detalleVenta) {
        sDetalleVenta.crearDetalleVenta(detalleVenta);
        return "redirect:/detalleventa/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarDetalleVenta(@PathVariable Integer id, Model model) {
        DetalleVenta detalleVenta = sDetalleVenta.buscarDetalleVentaPorId(id).orElse(null);
        model.addAttribute("detalleVenta", detalleVenta);
        model.addAttribute("productos", sProducto.listarProductos());
        model.addAttribute("ventas", sVenta.listarVentas());
        return "detalleventa/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDetalleVenta(@PathVariable Integer id) {
        sDetalleVenta.eliminarDetalleVenta(id);
        return "redirect:/detalleventa/listar";
    }
}
