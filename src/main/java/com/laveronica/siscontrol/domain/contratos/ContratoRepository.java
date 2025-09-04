package com.laveronica.siscontrol.domain.contratos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    boolean existsByContrato(String contrato);

}
