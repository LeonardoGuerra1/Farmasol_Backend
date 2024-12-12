package com.farmasol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_salida")
public class DetalleSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleSalida;

    @Column(columnDefinition = "int not null")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    @JsonIgnoreProperties(value = { "proveedor", "categoria", "marca" })
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idSalida")
    @JsonIgnoreProperties(value = { "usuario", "detalleSalidaList" })
    private SalidaProducto salidaProducto;
}
