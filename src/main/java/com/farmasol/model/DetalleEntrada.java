package com.farmasol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties(value = { "usuario", "proveedor", "detalleEntradaList" })
    private EntradaProducto entradaProducto;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    @JsonIgnoreProperties(value = { "proveedor", "categoria", "marca" })
    private Producto producto;
}
