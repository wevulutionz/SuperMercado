package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Categoria;

public interface RCategoria extends JpaRepository<Categoria, Integer> {
	List<Categoria> findByNombreContainingIgnoreCase(String nombre);
}
