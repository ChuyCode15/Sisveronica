package com.laveronica.siscontrol.domain.ordencompra.dto;

import com.laveronica.siscontrol.domain.ordencompradetalle.dto.DatosRegistroOrdenCompraDetalle;

import java.time.LocalDate;
import java.util.List;

public record DatosActulizarOrdenCompra(
        Long cliente_id,
        Long contrato_id,
        String partida,
        LocalDate fechaInicioSemana,
        LocalDate fechaFinSemana,
        List<DatosRegistroOrdenCompraDetalle> detalles
) {
}
