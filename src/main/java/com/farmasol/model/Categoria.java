package com.farmasol.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;

    @Column(columnDefinition = "varchar(100) not null")
    private String nombre;

    @Column(columnDefinition = "bit default 1")
    private boolean estado;
}
