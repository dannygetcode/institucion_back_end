package com.institucion.backend.alumno.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alumnos")
@Data                   
@NoArgsConstructor      
@AllArgsConstructor     
@Builder                
public class AlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String correo;
    private String programa;
}
