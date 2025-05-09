package com.institucion.backend.docente.repository;

import com.institucion.backend.docente.entity.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<DocenteEntity, Long> {
}
