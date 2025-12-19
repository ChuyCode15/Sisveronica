package com.laveronica.siscontrol.domain.ordencompradetalle.dto;

import com.laveronica.siscontrol.domain.ordencompradetalle.OrdenCompraDetalle;

public record DatosListarDetalleOrdenCompraDetalle(

        String producto,
        Double lunes,
        Double martes,
        Double miercoles,
        Double jueves,
        Double viernes,
        Double sabado,
        Double domingo
) {
    public DatosListarDetalleOrdenCompraDetalle(OrdenCompraDetalle datos) {
        this(
                datos.getProducto().getNombre(),
                datos.getLunes(),
                datos.getMartes(),
                datos.getMiercoles(),
                datos.getJueves(),
                datos.getViernes(),
                datos.getSabado(),
                datos.getDomingo()
        );
    }
}
