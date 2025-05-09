package com.institucion.backend.security;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
    private String rol; // ADMIN, DOCENTE o ALUMNO
}