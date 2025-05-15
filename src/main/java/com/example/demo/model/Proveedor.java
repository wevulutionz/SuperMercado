package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Proveedor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    private String nombre;
    private String correo;
    private String telefono;
    private LocalDateTime fechaRegistro = LocalDateTime.now();
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
}