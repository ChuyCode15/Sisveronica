package com.laveronica.siscontrol.domain.ordencompradetalle.dto;

import com.laveronica.siscontrol.domain.ordencompradetalle.OrdenCompraDetalle;

import java.time.LocalDate;

public record DatosDetalleOrdenCompraDetalle(

        Long id,
        Long ordenCompra,
        LocalDate fecha,
        String producto,
        Double lunes,
        Double martes,
        Double miercoles,
        Double jueves,
        Double viernes,
        Double sabado,
        Double domingo

) {
    public DatosDetalleOrdenCompraDetalle(OrdenCompraDetalle detalle) {
        this(
                detalle.getId(),
                detalle.getOrdenCompra().getId(),
                detalle.getFecha(),
                detalle.getProducto().getNombre(),
                detalle.getLunes(),
                detalle.getMartes(),
                detalle.getMiercoles(),
                detalle.getJueves(),
                detalle.getViernes(),
                detalle.getSabado(),
                detalle.getDomingo()
        );
    }
}
