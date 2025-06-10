package com.tuInventario.Inventario.domain.port;

import java.util.List;

import com.tuInventario.Inventario.domain.model.Producto;

public interface ProductoRepositoryPort {
    Producto save(Producto producto);
    List<Producto> findAll();
    Producto findById(Long id);
    void deleteById(Long id);
}