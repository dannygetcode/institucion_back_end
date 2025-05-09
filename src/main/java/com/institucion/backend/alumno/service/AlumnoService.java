package com.institucion.backend.alumno.service;

import com.institucion.backend.alumno.dto.AlumnoDTO;
import com.institucion.backend.alumno.entity.AlumnoEntity;
import com.institucion.backend.alumno.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository repo;

    public List<AlumnoDTO> listarTodos() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public AlumnoDTO buscarPorId(Long id) {
        return repo.findById(id).map(this::toDTO).orElse(null);
    }

    public AlumnoDTO crear(AlumnoDTO dto) {
        AlumnoEntity entity = toEntity(dto);
        return toDTO(repo.save(entity));
    }

    public AlumnoDTO actualizar(Long id, AlumnoDTO dto) {
        AlumnoEntity existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNombre(dto.getNombre());
        existente.setApellido(dto.getApellido());
        existente.setCorreo(dto.getCorreo());
        existente.setPrograma(dto.getPrograma());

        return toDTO(repo.save(existente));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    private AlumnoDTO toDTO(AlumnoEntity a) {
        AlumnoDTO dto = new AlumnoDTO();
        dto.setId(a.getId());
        dto.setNombre(a.getNombre());
        dto.setApellido(a.getApellido());
        dto.setCorreo(a.getCorreo());
        dto.setPrograma(a.getPrograma());
        return dto;
    }

    private AlumnoEntity toEntity(AlumnoDTO dto) {
        AlumnoEntity a = new AlumnoEntity();
        a.setNombre(dto.getNombre());
        a.setApellido(dto.getApellido());
        a.setCorreo(dto.getCorreo());
        a.setPrograma(dto.getPrograma());
        return a;
    }
}
