package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Categoria;
import com.example.demo.service.SCategoria;

@Controller
@RequestMapping("/categoria")
public class CCategoria {
	@Autowired
	private SCategoria service;
	@GetMapping("/listar")
	public String listarCategoria(
			@RequestParam(value = "nombre", required=false)String nombre,
			@RequestHeader(value = "X-Requested-With", required = false) String requestedWith,
			Model model) {
		List<Categoria> lista = service.buscarCategoriaPorNombre(nombre);
		model.addAttribute("categorias",lista);
        if ("XMLHttpRequest".equals(requestedWith)) {
            return "categoria/grilla :: grilla";
        }
        return "categoria/listar";
	}
    @GetMapping("/crear")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria/crear";
    }
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
    	service.crearCategoria(categoria);
    	return "redirect:/categoria/listar";
    }
    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Integer id,Model model) {
    	Categoria categoria = service.buscarCategoriaPorId(id).orElse(null);
    	model.addAttribute("categoria",categoria);
    	return "categoria/editar";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Integer id) {
    	service.eliminarCategoria(id);
    	return "redirect:/categoria/listar";
    }
}
