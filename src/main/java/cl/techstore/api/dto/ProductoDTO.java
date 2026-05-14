package cl.techstore.api.dto;

import lombok.Data;

/**
 * DTO para crear o modificar un producto.
 * Se recibe en el body del POST y PUT.
 */
@Data
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String categoria;
    private Boolean activo;
}
