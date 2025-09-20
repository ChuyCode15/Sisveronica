package com.laveronica.siscontrol.domain.categoria;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNombre(@NotNull String nombre);

    Optional<Categoria> findByIdAndActivoTrue(Long id);
}
