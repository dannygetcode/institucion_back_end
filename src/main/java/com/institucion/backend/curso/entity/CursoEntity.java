package com.institucion.backend.curso.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private String descripcion;
    private int creditos;
}
