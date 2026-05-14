package cl.techstore.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO para devolver el token JWT tras un login exitoso
 */
@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String tipo;
    private String expiracion;
}
