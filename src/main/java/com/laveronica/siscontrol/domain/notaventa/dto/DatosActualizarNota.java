package com.laveronica.siscontrol.domain.notaventa.dto;

import com.laveronica.siscontrol.domain.notaventadetalle.dto.NotaVentaActualizarDetalle;

import java.util.List;

public record DatosActualizarNota(

        String partida,
        List<NotaVentaActualizarDetalle> detalles

) {
}
