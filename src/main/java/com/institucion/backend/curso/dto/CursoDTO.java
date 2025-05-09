package com.institucion.backend.curso.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoDTO {

    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int creditos;
}
