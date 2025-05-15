package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Venta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    private String numeroDocumento;
    private String tipoPago;
    private LocalDateTime fechaRegistro = LocalDateTime.now();
    private Double total;
    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalleVentas;
}