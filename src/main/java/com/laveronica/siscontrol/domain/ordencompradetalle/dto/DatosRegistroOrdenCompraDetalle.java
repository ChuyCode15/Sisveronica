package com.laveronica.siscontrol.domain.ordencompradetalle.dto;

import com.laveronica.siscontrol.domain.ordencompra.OrdenCompra;

import java.time.LocalDate;

public record DatosRegistroOrdenCompraDetalle(

        LocalDate fecha,
        Long producto,
        Double lunes,
        Double martes,
        Double miercoles,
        Double jueves,
        Double viernes,
        Double sabado,
        Double domingo
) {
}
