package com.institucion.backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
                )
            );
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }

        var usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow();

        String token = jwtService.generateToken(
            org.springframework.security.core.userdetails.User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.getRol().name())
                .build()
        );

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        if (usuarioRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("El usuario ya existe.");
        }

        UsuarioEntity nuevo = UsuarioEntity.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .rol(Role.valueOf(request.getRol().toUpperCase()))
            .build();

        usuarioRepository.save(nuevo);
        return ResponseEntity.ok("Usuario creado exitosamente.");
    }
    
}