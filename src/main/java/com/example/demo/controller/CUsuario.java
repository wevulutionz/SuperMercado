package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.SUsuario;
import com.example.demo.service.SRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class CUsuario {

    @Autowired
    private SUsuario sUsuario;

    @Autowired
    private SRol sRol;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", sUsuario.listarUsuarios());
        return "usuario/listar";
    }

    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", sRol.listarRoles());
        return "usuario/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        sUsuario.crearUsuario(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Integer id, Model model) {
        Usuario usuario = sUsuario.buscarUsuarioPorId(id).orElse(null);
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", sRol.listarRoles());
        return "usuario/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        sUsuario.eliminarUsuario(id);
        return "redirect:/usuario/listar";
    }
}
