package com.institucion.backend.docente.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "docentes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String correo;
    private String area;
}
