package com.farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_entrada")
public class DetalleEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleEntrada;

    @Column(columnDefinition = "int not null")
    private int cantidad;

    @Column(columnDefinition = "decimal(6, 2) not null")
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "idEntrada")
    private EntradaProducto entradaProducto;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
}
