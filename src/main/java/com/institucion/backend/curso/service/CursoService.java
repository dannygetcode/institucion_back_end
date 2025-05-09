package com.institucion.backend.curso.service;

import com.institucion.backend.curso.dto.CursoDTO;
import com.institucion.backend.curso.entity.CursoEntity;
import com.institucion.backend.curso.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository repo;

    public List<CursoDTO> listar() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public CursoDTO buscarPorId(Long id) {
        return repo.findById(id).map(this::toDTO).orElse(null);
    }

    public CursoDTO crear(CursoDTO dto) {
        return toDTO(repo.save(toEntity(dto)));
    }

    public CursoDTO actualizar(Long id, CursoDTO dto) {
        CursoEntity curso = repo.findById(id).orElse(null);
        if (curso == null) return null;

        curso.setCodigo(dto.getCodigo());
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setCreditos(dto.getCreditos());

        return toDTO(repo.save(curso));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    private CursoDTO toDTO(CursoEntity c) {
        return CursoDTO.builder()
                .id(c.getId())
                .codigo(c.getCodigo())
                .nombre(c.getNombre())
                .descripcion(c.getDescripcion())
                .creditos(c.getCreditos())
                .build();
    }

    private CursoEntity toEntity(CursoDTO dto) {
        return CursoEntity.builder()
                .codigo(dto.getCodigo())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .creditos(dto.getCreditos())
                .build();
    }
}
