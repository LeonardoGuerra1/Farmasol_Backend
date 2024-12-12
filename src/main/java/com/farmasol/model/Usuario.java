package com.farmasol.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(columnDefinition = "varchar(50) not null")
    private String nombre;

    @Column(columnDefinition = "varchar(50) not null")
    private String apellido;

    @Column(columnDefinition = "varchar(255) not null")
    private String contrasena;

    @Column(columnDefinition = "varchar(9) not null")
    private String telefono;

    @Column(columnDefinition = "enum('admin', 'empleado') default 'empleado' not null")
    private String rol;

    @Column(columnDefinition = "varchar(50) not null")
    private String nom_user;

    @Column(columnDefinition = "char(8) not null")
    private String dni;

    @Column(columnDefinition = "bit default 1")
    private boolean estado;  
}
