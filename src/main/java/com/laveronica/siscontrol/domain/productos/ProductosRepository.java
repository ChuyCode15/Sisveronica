package com.laveronica.siscontrol.domain.productos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductosRepository extends JpaRepository<Producto, Long> {
    Optional findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
