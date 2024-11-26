package com.pruebatecnica.tienda.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String nombre;

    @Getter
    @Setter
    private String descripcion;

    @Getter
    @Setter
    @Column(nullable = false)
    private Double precio;

    @Getter
    @Setter
    @Column(name = "cantidad_disponible", nullable = false)
    private Integer cantidadDisponible;

    @Getter
    @Setter
    private String foto;
}
