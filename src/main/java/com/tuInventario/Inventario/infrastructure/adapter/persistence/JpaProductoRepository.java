package com.tuInventario.Inventario.infrastructure.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductoRepository extends JpaRepository<ProductoEntity, Long> {}