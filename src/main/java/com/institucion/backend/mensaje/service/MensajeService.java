package com.institucion.backend.mensaje.service;

import com.institucion.backend.mensaje.dto.MensajeRequest;
import com.institucion.backend.mensaje.entity.Mensaje;

import java.util.List;

public interface MensajeService {
    void guardarMensaje(MensajeRequest request);
    List<Mensaje> listarTodos();
}
