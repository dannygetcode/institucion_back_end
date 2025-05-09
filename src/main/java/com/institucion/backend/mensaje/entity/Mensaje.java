package com.institucion.backend.mensaje.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String asunto;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    private LocalDateTime fechaEnvio;
}
