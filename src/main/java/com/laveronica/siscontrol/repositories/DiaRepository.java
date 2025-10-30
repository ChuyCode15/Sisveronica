package com.laveronica.siscontrol.repositories;

import com.laveronica.siscontrol.domain.dias.Dia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DiaRepository extends JpaRepository<Dia, Long> {
    Optional<Dia> findByFecha(LocalDate fecha);
}
