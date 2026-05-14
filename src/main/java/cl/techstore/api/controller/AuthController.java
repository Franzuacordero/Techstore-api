package cl.techstore.api.controller;

import cl.techstore.api.dto.LoginRequest;
import cl.techstore.api.dto.LoginResponse;
import cl.techstore.api.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Controlador de autenticación.
 * POST /auth/login → valida credenciale y retorna token JWT.
 *
 * Las credenciales se comparan contra los valores de application.properties,
 * NO contra la base de datos.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.security.username}")
    private String adminUsername;

    @Value("${app.security.password}")
    private String adminPassword;

    @Value("${app.jwt.expiration}")
    private String expiration;

    /**
     * POST /auth/login
     * Body: { "username": "admin@techstore.cl", "password": "Admin1234" }
     * Respuesta: { "token": "...", "tipo": "Bearer", "expiracion": "3600000" }
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        // Valida credenciales y retorna token JWT
        if (!adminUsername.equals(request.getUsername()) ||
            !adminPassword.equals(request.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales incorrectas");
        }


        String token = jwtUtil.generarToken(request.getUsername());

        return ResponseEntity.ok(new LoginResponse(token, "Bearer", expiration));
    }
}
