package com.farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(columnDefinition = "varchar(50) not null")
    private String nombre;

    @Column(columnDefinition = "text null")
    private String descripcion;

    @Column(columnDefinition = "double not null")
    private double precio;

    @Column(columnDefinition = "int not null")
    private int stock;

    @Column(columnDefinition = "bit default 1")
    private boolean estado;

    @Column(columnDefinition = "datetime not null")
    private LocalDate fechaVencimiento;

//    @Column(columnDefinition = "int not null")
//    private int idProveedor;
//    @Column(columnDefinition = "int not null")
//    private int idCategoria;
//    @Column(columnDefinition = "int not null")
//    private int idMarca;

    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;

}
