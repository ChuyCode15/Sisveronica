package com.laveronica.siscontrol.domain.notaventadetalle.dto;

import java.math.BigDecimal;

public record DatosDetalleNotaDetalle(
        Long id,
        Integer cantidad,
        String producto,
        BigDecimal precio,
        BigDecimal SubTotal
) {
}
