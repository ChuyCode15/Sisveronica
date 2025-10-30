package com.laveronica.siscontrol.repositories;

import com.laveronica.siscontrol.domain.contratos.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    boolean existsByContrato(String contrato);

}
