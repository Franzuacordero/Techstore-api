package cl.techstore.api.service;

import cl.techstore.api.dto.ProductoDTO;
import cl.techstore.api.model.Producto;
import cl.techstore.api.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de Producto — contiene toda la lógica de negocio.
 * El controlador solo llama a este servicio, nunca accede al repositorio directamente.
 */
@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    /**
     * Retorna todos los productos existentes en la BD.
     */
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    /**
     * Crea un nuevo producto a partir del DTO recibido.
     */
    public Producto crear(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoria(dto.getCategoria());
        producto.setActivo(dto.getActivo() != null ? dto.getActivo() : true);
        return productoRepository.save(producto);
    }

    /**
     * Modifica un producto existente por su ID.
     * Lanza excepción si el producto no existe.
     */
    public Producto modificar(Long id, ProductoDTO dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoria(dto.getCategoria());
        if (dto.getActivo() != null) {
            producto.setActivo(dto.getActivo());
        }
        return productoRepository.save(producto);
    }

    /**
     // Borrado lógico: cambia activo a false
     */
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        producto.setActivo(false);
        productoRepository.save(producto);
    }
}
