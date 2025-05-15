package com.example.demo.repository;

import com.example.demo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RProducto extends JpaRepository<Producto, Integer> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    List<Producto> findByCategoriaIdCategoria(Integer categoriaId);

    List<Producto> findByProveedorIdProveedor(Integer proveedorId);

    @Query("SELECT p FROM Producto p WHERE " +
           "(:nombre IS NULL OR LOWER(p.nombre) LIKE %:nombre%) AND " +
           "(:categoriaId IS NULL OR p.categoria.idCategoria = :categoriaId) AND " +
           "(:proveedorId IS NULL OR p.proveedor.idProveedor = :proveedorId)")
    List<Producto> buscarProductosConFiltros(String nombre, Integer categoriaId, Integer proveedorId);
}
