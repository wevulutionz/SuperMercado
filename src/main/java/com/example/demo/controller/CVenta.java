package com.example.demo.controller;

import com.example.demo.model.Venta;
import com.example.demo.service.SVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/venta")
public class CVenta {

    @Autowired
    private SVenta sVenta;

    @GetMapping("/listar")
    public String listarVentas(Model model) {
        model.addAttribute("ventas", sVenta.listarVentas());
        return "venta/listar";
    }

    @GetMapping("/nuevo")
    public String nuevaVenta(Model model) {
        model.addAttribute("venta", new Venta());
        return "venta/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute Venta venta) {
        sVenta.crearVenta(venta);
        return "redirect:/venta/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarVenta(@PathVariable Integer id, Model model) {
        Venta venta = sVenta.buscarVentaPorId(id).orElse(null);
        model.addAttribute("venta", venta);
        return "venta/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVenta(@PathVariable Integer id) {
        sVenta.eliminarVenta(id);
        return "redirect:/venta/listar";
    }
}
