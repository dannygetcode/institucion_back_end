package com.institucion.backend.mensaje.dto;
import lombok.*;
@Data
public class MensajeRequest {
    private String nombre;
    private String email;
    private String asunto;
    private String contenido;
}
