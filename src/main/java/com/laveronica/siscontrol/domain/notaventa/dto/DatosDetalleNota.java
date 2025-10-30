package com.laveronica.siscontrol.domain.notaventa.dto;

import com.laveronica.siscontrol.domain.notaventa.NotaVenta;
import com.laveronica.siscontrol.domain.notaventadetalle.NotaVentaDetalle;
import com.laveronica.siscontrol.domain.valores.Partida;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record DatosDetalleNota(

        Long id,
        LocalDateTime fecha,
        String cliente,
        Partida partida,
        List<NotaVentaDetalle> detalles,
        BigDecimal totalGeneral

) {

    public DatosDetalleNota(NotaVenta datos){
        this(
                datos.getId(),
                datos.getFecha(),
                datos.getCliente().getNombre(),
                datos.getPartida(),
                datos.getDetalles(),
                datos.getTotalGeneral()
        );
    }
}
