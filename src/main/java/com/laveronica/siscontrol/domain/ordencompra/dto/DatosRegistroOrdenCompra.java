package com.laveronica.siscontrol.domain.ordencompra.dto;

import com.laveronica.siscontrol.domain.ordencompradetalle.dto.DatosRegistroOrdenCompraDetalle;
import com.laveronica.siscontrol.domain.valores.Partida;

import java.time.LocalDate;
import java.util.List;

public record DatosRegistroOrdenCompra(

        Long cliente_id,
        Long contrato_id,
        String partida,
        LocalDate fechaInicioSemana,
        LocalDate fechaFinSemana,
        List<DatosRegistroOrdenCompraDetalle> detalles

) {
}
