package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Usuario;

public interface RUsuario extends JpaRepository<Usuario, Integer> {
}

