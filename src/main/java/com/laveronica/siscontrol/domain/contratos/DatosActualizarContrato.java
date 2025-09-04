package com.laveronica.siscontrol.domain.contratos;

import java.time.LocalDate;

public record DatosActualizarContrato(

        Long clienteId,
        Partida partida,
        LocalDate fechaInicio,
        LocalDate fechaTermino
) {
}
