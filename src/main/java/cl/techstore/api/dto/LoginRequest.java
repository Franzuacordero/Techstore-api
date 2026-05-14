package cl.techstore.api.dto;

import lombok.Data;

/**
 * DTO para recibir las credenciales en POST /auth/login
 */
@Data
public class LoginRequest {
    private String username;
    private String password;
}
