package com.example.demo.controller;

import com.example.demo.model.Rol;
import com.example.demo.service.SRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rol")
public class CRol {

    @Autowired
    private SRol sRol;

    @GetMapping("/listar")
    public String listarRoles(Model model) {
        model.addAttribute("roles", sRol.listarRoles());
        return "rol/listar";
    }

    @GetMapping("/nuevo")
    public String nuevoRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "rol/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarRol(@ModelAttribute Rol rol) {
        sRol.crearRol(rol);
        return "redirect:/rol/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarRol(@PathVariable Integer id, Model model) {
        Rol rol = sRol.buscarRolPorId(id).orElse(null);
        model.addAttribute("rol", rol);
        return "rol/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRol(@PathVariable Integer id) {
        sRol.eliminarRol(id);
        return "redirect:/rol/listar";
    }
}
