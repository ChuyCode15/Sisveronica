package com.laveronica.siscontrol.domain.ordencompradetalle.dto;

import com.laveronica.siscontrol.domain.ordencompra.OrdenCompra;

import java.time.LocalDate;

public record DatosRegistroOrdenCompraDetalle(
        OrdenCompra ordenCompra,
        LocalDate fecha,
        double lunes,
        double martes,
        double miercoles,
        double jueves,
        double viernes,
        double sabado,
        double domingo
) {
}
