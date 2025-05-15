package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.DetalleVenta;

public interface RDetalleVenta extends JpaRepository<DetalleVenta, Integer> {
}
