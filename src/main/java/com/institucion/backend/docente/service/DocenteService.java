package com.institucion.backend.docente.service;

import com.institucion.backend.docente.dto.DocenteDTO;
import com.institucion.backend.docente.entity.DocenteEntity;
import com.institucion.backend.docente.repository.DocenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocenteService {

    private final DocenteRepository repo;

    public List<DocenteDTO> listar() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public DocenteDTO buscarPorId(Long id) {
        return repo.findById(id).map(this::toDTO).orElse(null);
    }

    public DocenteDTO crear(DocenteDTO dto) {
        return toDTO(repo.save(toEntity(dto)));
    }

    public DocenteDTO actualizar(Long id, DocenteDTO dto) {
        DocenteEntity existente = repo.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setNombre(dto.getNombre());
        existente.setApellido(dto.getApellido());
        existente.setCorreo(dto.getCorreo());
        existente.setArea(dto.getArea());

        return toDTO(repo.save(existente));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    private DocenteDTO toDTO(DocenteEntity d) {
        return DocenteDTO.builder()
                .id(d.getId())
                .nombre(d.getNombre())
                .apellido(d.getApellido())
                .correo(d.getCorreo())
                .area(d.getArea())
                .build();
    }

    private DocenteEntity toEntity(DocenteDTO dto) {
        return DocenteEntity.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .correo(dto.getCorreo())
                .area(dto.getArea())
                .build();
    }
}
