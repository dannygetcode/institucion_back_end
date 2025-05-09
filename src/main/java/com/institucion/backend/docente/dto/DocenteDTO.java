package com.institucion.backend.docente.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocenteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String area;
}
