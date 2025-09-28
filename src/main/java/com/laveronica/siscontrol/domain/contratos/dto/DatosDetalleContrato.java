package com.laveronica.siscontrol.domain.contratos.dto;

import com.laveronica.siscontrol.domain.contratos.Contrato;

import java.time.LocalDate;

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
