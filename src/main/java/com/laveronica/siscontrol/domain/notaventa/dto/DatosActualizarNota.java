package com.laveronica.siscontrol.domain.notaventa.dto;

import com.laveronica.siscontrol.domain.notaventadetalle.dto.NotaVentaActualizarDetalle;
import com.laveronica.siscontrol.domain.valores.Partida;

import java.util.List;

public record DatosActualizarNota(

        String partida,
        List<NotaVentaActualizarDetalle> detalles

) {
}
