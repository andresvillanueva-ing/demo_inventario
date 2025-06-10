package com.tuInventario.Inventario;

import org.springframework.boot.SpringApplication;
import com.tuInventario.Inventario.infrastructure.adapter.persistence.ProductoRepositoryAdapter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tuInventario.Inventario.application.service.ProductoService;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public ProductoService productoService(ProductoRepositoryAdapter adapter) {
        return new ProductoService(adapter);
    }
}