// package com.institucion.backend.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class WebSecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         return http
//             .csrf(csrf -> csrf.disable())  // Desactiva CSRF (para desarrollo)
//             .authorizeHttpRequests(auth -> auth
//                 .anyRequest().authenticated()  // Requiere autenticación para todo
//             )
//             .httpBasic(basic -> {})  // Activa Basic Auth explícitamente
//             .build();
//     }
// }
