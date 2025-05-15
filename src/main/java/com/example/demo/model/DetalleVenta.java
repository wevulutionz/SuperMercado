package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DetalleVenta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;
    private Integer cantidad;
    private Double precio;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
}
