package com.institucion.backend.mensaje.service;

import com.institucion.backend.mensaje.dto.MensajeRequest;
import com.institucion.backend.mensaje.entity.Mensaje;
import com.institucion.backend.mensaje.repository.MensajeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MensajeServiceImpl implements MensajeService {
    private final MensajeRepository repository;

    @Override
    public void guardarMensaje(MensajeRequest request) {
        Mensaje mensaje = Mensaje.builder()
            .nombre(request.getNombre())
            .email(request.getEmail())
            .asunto(request.getAsunto())
            .contenido(request.getContenido())
            .fechaEnvio(LocalDateTime.now())
            .build();
        repository.save(mensaje);
    }

    @Override
    public List<Mensaje> listarTodos() {
        return repository.findAll();
    }
}
