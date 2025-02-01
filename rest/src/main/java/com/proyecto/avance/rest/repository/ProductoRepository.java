package com.proyecto.avance.rest.repository;

import com.proyecto.avance.rest.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {
}