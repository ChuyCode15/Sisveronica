package com.laveronica.siscontrol.repositories;

import com.laveronica.siscontrol.domain.clientes.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByNombre(String nombre);

    Cliente findByNombre(String cliente);
}
