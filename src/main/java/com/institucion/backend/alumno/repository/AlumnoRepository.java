package com.institucion.backend.alumno.repository;

import com.institucion.backend.alumno.entity.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Long> {
}
