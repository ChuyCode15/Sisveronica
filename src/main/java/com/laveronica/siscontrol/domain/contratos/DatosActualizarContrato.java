package com.laveronica.siscontrol.domain.contratos;

import com.laveronica.siscontrol.domain.valores.Partida;

import java.time.LocalDate;

public record DatosActualizarContrato(

        Long clienteId,
        Partida partida,
        LocalDate fechaInicio,
        LocalDate fechaTermino
) {
}
