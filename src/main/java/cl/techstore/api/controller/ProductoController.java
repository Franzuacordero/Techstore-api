package cl.techstore.api.controller;

import cl.techstore.api.dto.ProductoDTO;
import cl.techstore.api.model.Producto;
import cl.techstore.api.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de productos.
 * Todos los endpoints requieren token JWT en el header:
 * Authorization: Bearer <token>
 *
 * GET    /api/productos        → lista todos los productos
 * POST   /api/productos        → crea un producto nuevo
 * PUT    /api/productos/{id}   → modifica un producto existente
 * DELETE /api/productos/{id}   → eliminación lógica (activo = false)
 */
@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    /**
     * GET /api/productos
     * Retorna todos los productos (incluyendo los inactivos).
     * HTTP 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(productoService.listarTodos());
    }

    /**
     * POST /api/productos
     * Crea un nuevo producto con los datos del body.
     * HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody ProductoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoService.crear(dto));
    }

    /**
     * PUT /api/productos/{id}
     * Modifica todos los campos de un producto existente.
     * HTTP 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producto> modificar(@PathVariable Long id,
                                               @RequestBody ProductoDTO dto) {
        return ResponseEntity.ok(productoService.modificar(id, dto));
    }

    /**
     * DELETE /api/productos/{id}
     * NO borra el registro. Solo cambia activo = false (borrado lógico).
     * HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
