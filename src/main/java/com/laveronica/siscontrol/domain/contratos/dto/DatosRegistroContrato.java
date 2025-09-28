package com.laveronica.siscontrol.domain.contratos.dto;

import com.laveronica.siscontrol.domain.valores.Partida;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosRegistroContrato(

        @NotNull
        Long clienteId,
        @NotNull
        String contrato,
        @NotNull
        Partida partida,
        @NotNull
        LocalDate fechaInicio,

        LocalDate fechaTermino

) {

}
