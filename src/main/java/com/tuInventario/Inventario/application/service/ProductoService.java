package com.tuInventario.Inventario.application.service;

import java.util.List;

import com.tuInventario.Inventario.domain.model.Producto;
import com.tuInventario.Inventario.domain.port.ProductoRepositoryPort;

public class ProductoService {
    private final ProductoRepositoryPort repository;

    public ProductoService(ProductoRepositoryPort repository) {
        this.repository = repository;
    }

    public Producto crearProducto(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    public Producto obtenerProducto(Long id) {
        return repository.findById(id);
    }

    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }

    public Producto actualizarProducto(Long id, Producto productoActualizado){
        Producto productoExistente = repository.findById(id);
        if (productoExistente == null){
            throw new RuntimeException("producto no encontrado con ID: "+ id);
        }
        productoExistente.setNombre(productoActualizado.getNombre());
        productoExistente.setDescripcion(productoActualizado.getDescripcion());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        productoExistente.setCantidad(productoActualizado.getCantidad());

        return repository.save(productoExistente);
    }

}