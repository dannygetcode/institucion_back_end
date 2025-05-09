package com.institucion.backend.alumno.controller;

import com.institucion.backend.alumno.dto.AlumnoDTO;
import com.institucion.backend.alumno.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public List<AlumnoDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public AlumnoDTO obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public AlumnoDTO crear(@RequestBody AlumnoDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public AlumnoDTO actualizar(@PathVariable Long id, @RequestBody AlumnoDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
