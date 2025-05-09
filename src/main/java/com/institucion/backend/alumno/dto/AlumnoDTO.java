package com.institucion.backend.alumno.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumnoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String programa;
}
