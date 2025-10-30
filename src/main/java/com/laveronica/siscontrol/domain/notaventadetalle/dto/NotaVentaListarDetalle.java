package com.laveronica.siscontrol.domain.notaventadetalle.dto;

import com.laveronica.siscontrol.domain.notaventadetalle.NotaVentaDetalle;

import java.math.BigDecimal;

public record NotaVentaListarDetalle(
        Integer cantidad,
        String producto,
        BigDecimal precio,
        BigDecimal subTotal
) {
    public NotaVentaListarDetalle(NotaVentaDetalle detalles){
        this(
                detalles.getCantidad(),
                detalles.getProducto().getNombre(),
                detalles.getPrecioVenta(),
                detalles.getSubTotal()
        );


    }

}
