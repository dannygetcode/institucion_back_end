package com.institucion.backend.curso.controller;

import com.institucion.backend.curso.dto.CursoDTO;
import com.institucion.backend.curso.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService service;

    @GetMapping
    public List<CursoDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CursoDTO obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CursoDTO crear(@RequestBody CursoDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public CursoDTO actualizar(@PathVariable Long id, @RequestBody CursoDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
