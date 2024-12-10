package com.farmasol.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "entrada_producto")
public class EntradaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntrada;

    @Column(columnDefinition = "datetime not null")
    private LocalDate fechaRegistro;

    @Column(columnDefinition = "decimal(6, 2) not null")
    private double montoTotal;

    @Column(columnDefinition = "bit default 1")
    public boolean estado;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @OneToMany(mappedBy = "entradaProducto")
    private List<DetalleEntrada> detalleEntradaList;
}
