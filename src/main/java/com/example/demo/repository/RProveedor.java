package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Proveedor;

public interface RProveedor extends JpaRepository<Proveedor, Integer> {
	List<Proveedor> findByNombreContainingIgnoreCase(String nombre);
}
