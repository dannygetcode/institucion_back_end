package com.institucion.backend.docente.controller;

import com.institucion.backend.docente.dto.DocenteDTO;
import com.institucion.backend.docente.service.DocenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
@RequiredArgsConstructor
public class DocenteController {

    private final DocenteService service;

    @GetMapping
    public List<DocenteDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DocenteDTO obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public DocenteDTO crear(@RequestBody DocenteDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public DocenteDTO actualizar(@PathVariable Long id, @RequestBody DocenteDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
