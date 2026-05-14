package cl.techstore.api.repository;

import cl.techstore.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para Producto.
 * JpaRepository ya trae los métodos findAll, findById, save, deleteById, etc.
 * No necesitamos escribir SQL.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
