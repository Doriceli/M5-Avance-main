package com.proyecto.avance.rest.controller;

import com.proyecto.avance.rest.model.Producto;
import com.proyecto.avance.rest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable String id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String id, @RequestBody Producto productoActualizado) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            return ResponseEntity.ok(productoRepository.save(producto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}