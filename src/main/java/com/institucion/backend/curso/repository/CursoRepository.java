package com.institucion.backend.curso.repository;

import com.institucion.backend.curso.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> {
}
