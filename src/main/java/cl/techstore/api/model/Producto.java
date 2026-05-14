package cl.techstore.api.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad Producto — representa la tabla "productos" en PostgreSQL.
 * Solo esta tabla existe en la BD. Los usuarios van en el código, no aquí.
 */
@Entity
@Table(name = "productos")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del producto — obligatorio
    @Column(nullable = false, length = 100)
    private String nombre;

    // Descripción breve — opcional
    @Column(length = 255)
    private String descripcion;

    // Precio en CLP — obligatorio, debe ser mayor a 0
    @Column(nullable = false)
    private Double precio;

    // Unidades en bodega — obligatorio, mayor o igual a 0
    @Column(nullable = false)
    private Integer stock;

    // Categoría — ej: Electrónica, Hogar, Ropa
    @Column(nullable = false, length = 50)
    private String categoria;

    // Disponibilidad — true = activo, false = eliminado lógicamente
    @Column(nullable = false)
    private Boolean activo = true;
}
