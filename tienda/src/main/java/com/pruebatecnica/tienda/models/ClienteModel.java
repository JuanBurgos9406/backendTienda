package com.pruebatecnica.tienda.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {


    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;

    @Getter
    @Setter
    @Column(nullable = false)
    private String nombreCliente;

    @Getter
    @Setter
    @Column(nullable = false)
    private String apellidoCliente;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(nullable = false)
    private String telefono;


}
