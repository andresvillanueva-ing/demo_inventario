package com.tuInventario.Inventario.infrastructure.adapter.persistence;

import org.springframework.stereotype.Repository;

import com.tuInventario.Inventario.domain.model.Producto;
import com.tuInventario.Inventario.domain.port.ProductoRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final JpaProductoRepository jpaRepository;

    public ProductoRepositoryAdapter(JpaProductoRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Producto save(Producto producto) {
        ProductoEntity entity = toEntity(producto);
        return toModel(jpaRepository.save(entity));
    }

    @Override
    public List<Producto> findAll() {
        return jpaRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public Producto findById(Long id) {
        return jpaRepository.findById(id).map(this::toModel).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private ProductoEntity toEntity(Producto producto) {
        ProductoEntity entity = new ProductoEntity();
        entity.setId(producto.getId());
        entity.setNombre(producto.getNombre());
        entity.setDescripcion(producto.getDescripcion());
        entity.setPrecio(producto.getPrecio());
        entity.setCantidad(producto.getCantidad());
        return entity;
    }

    private Producto toModel(ProductoEntity entity) {
        Producto producto = new Producto();
        producto.setId(entity.getId());
        producto.setNombre(entity.getNombre());
        producto.setDescripcion(entity.getDescripcion());
        producto.setPrecio(entity.getPrecio());
        producto.setCantidad(entity.getCantidad());
        return producto;
    }
}