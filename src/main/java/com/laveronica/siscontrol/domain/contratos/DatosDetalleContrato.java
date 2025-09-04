package com.laveronica.siscontrol.domain.contratos;

import com.laveronica.siscontrol.domain.clientes.Cliente;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

public record DatosDetalleContrato(
        Long id,
        String cliente,
        String contrato,
        String partida,
        LocalDate fechaInicio,
        LocalDate fechaTermino

        ) {
    public DatosDetalleContrato(Contrato contrato){
        this(
                contrato.getId(),
                contrato.getCliente().getNombre(),
                contrato.getContrato(),
                contrato.getPartida().name(),
                contrato.getFechaInicio(),
                contrato.getFechaTermino()
        );
    }
}
