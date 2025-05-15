package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.SProducto;
import com.example.demo.service.SCategoria;
import com.example.demo.service.SProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class CProducto {

    @Autowired
    private SProducto sProducto;

    @Autowired
    private SCategoria sCategoria;

    @Autowired
    private SProveedor sProveedor;

    @GetMapping("/listar")
    public String listarProductos(@RequestParam(value = "nombre", required = false) String nombre,
                                  @RequestParam(value = "categoriaId", required = false) Integer categoriaId,
                                  @RequestParam(value = "proveedorId", required = false) Integer proveedorId,
                                  @RequestHeader(value="X-Requested-With", required= false) String requestedWith,
                                  Model model) {
        List<Producto> productos = sProducto.buscarProductosConFiltros(nombre, categoriaId, proveedorId);
        model.addAttribute("productos", productos);
        if ("XMLHttpRequest".equals(requestedWith)) {
            return "producto/grilla :: grilla";
        }
        model.addAttribute("categorias", sCategoria.listarCategorias());
        model.addAttribute("proveedores", sProveedor.listarProveedores());
        return "producto/listar";
    }

    @GetMapping("/crear")
    public String nuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", sCategoria.listarCategorias());
        model.addAttribute("proveedores", sProveedor.listarProveedores());
        return "producto/crear";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        sProducto.crearProducto(producto);
        return "redirect:/producto/listar"; 
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable Integer id, Model model) {
        Producto producto = sProducto.buscarProductoPorId(id).orElse(null);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", sCategoria.listarCategorias());
        model.addAttribute("proveedores", sProveedor.listarProveedores());
        return "producto/editar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        sProducto.eliminarProducto(id);
        return "redirect:/producto/listar";
    }
}
