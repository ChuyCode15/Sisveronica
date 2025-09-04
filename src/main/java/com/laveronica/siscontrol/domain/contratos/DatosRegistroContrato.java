package com.laveronica.siscontrol.domain.contratos;

import com.laveronica.siscontrol.domain.clientes.Cliente;
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
