package com.farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "salida_producto")
public class SalidaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalida;

    @Column(columnDefinition = "datetime not null")
    private LocalDate fechaRegistro;

    @Column(columnDefinition = "bit default 1")
    private boolean estado;

    @Column(columnDefinition = "text not null")
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "salidaProducto")
    private List<DetalleSalida> detalleSalidaList;
}
