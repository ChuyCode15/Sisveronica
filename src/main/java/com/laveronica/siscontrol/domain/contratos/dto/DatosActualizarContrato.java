package com.laveronica.siscontrol.domain.contratos.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public record DatosActualizarContrato(

        Long clienteId,
        LocalDate fechaInicio,
        LocalDate fechaTermino,
        BigDecimal presupuesto
) {
}
