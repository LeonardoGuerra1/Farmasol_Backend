package com.farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;

    @Column(columnDefinition = "varchar(100) not null")
    private String direccion;

    @Column(columnDefinition = "datetime not null")
    private LocalDate fechaRegistro;

    @Column(columnDefinition = "varchar(50) not null")
    private String email;

    @Column(columnDefinition = "varchar(100) not null")
    private String nombre;

    @Column(columnDefinition = "char(11) not null")
    private String ruc;

    @Column(columnDefinition = "varchar(9) not null")
    private String telefono;

    @Column(columnDefinition = "bit default 1")
    private boolean estado;

    @Column(columnDefinition = "varchar(50) not null")
    private String nombreRepresentante;

}
