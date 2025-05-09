package com.institucion.backend.mensaje.controller;

import com.institucion.backend.mensaje.dto.MensajeRequest;
import com.institucion.backend.mensaje.entity.Mensaje;
import com.institucion.backend.mensaje.service.MensajeService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
@RequiredArgsConstructor
public class MensajeController {

    private final MensajeService mensajeService;

    // Ruta pública: cualquier visitante puede enviar un mensaje
    @PostMapping
    public ResponseEntity<Void> enviarMensaje(@RequestBody MensajeRequest request) {
        mensajeService.guardarMensaje(request);
        return ResponseEntity.ok().build();
    }

    // Ruta protegida: solo usuarios autenticados con rol ADMIN o DOCENTE pueden ver los mensajes
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCENTE')")
    public ResponseEntity<List<Mensaje>> listarMensajes() {
        return ResponseEntity.ok(mensajeService.listarTodos());
    }
}
