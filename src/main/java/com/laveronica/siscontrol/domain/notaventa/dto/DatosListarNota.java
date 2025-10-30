package com.laveronica.siscontrol.domain.notaventa.dto;

import com.laveronica.siscontrol.domain.notaventa.NotaVenta;
import com.laveronica.siscontrol.domain.notaventadetalle.dto.NotaVentaListarDetalle;
import com.laveronica.siscontrol.domain.valores.Partida;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DatosListarNota(
        Long id,
        LocalDateTime fecha,
        String cliente,
        Partida partida,
        List<NotaVentaListarDetalle> detalles,
        BigDecimal totalGeneral

) {
    public DatosListarNota(NotaVenta datos) {
        this(
                datos.getId(),
                datos.getFecha(),
                datos.getCliente().getNombre(),
                datos.getPartida(),
                datos.getDetalles().stream()
                        .map(
                        detalle -> new NotaVentaListarDetalle(detalle))
                        .collect(Collectors.toList()),
                datos.getTotalGeneral()
        );
    }

}
