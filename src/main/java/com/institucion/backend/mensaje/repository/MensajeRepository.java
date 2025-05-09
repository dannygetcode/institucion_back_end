package com.institucion.backend.mensaje.repository;

import com.institucion.backend.mensaje.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}
