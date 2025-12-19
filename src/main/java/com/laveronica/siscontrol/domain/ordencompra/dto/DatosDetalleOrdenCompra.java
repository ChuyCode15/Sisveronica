package com.laveronica.siscontrol.domain.ordencompra.dto;

import com.laveronica.siscontrol.domain.ordencompra.OrdenCompra;
import com.laveronica.siscontrol.domain.ordencompradetalle.dto.DatosDetalleOrdenCompraDetalle;
import com.laveronica.siscontrol.domain.valores.Partida;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record DatosDetalleOrdenCompra(
        Long id,
        String cliente,
        String contrato,
        Partida partida,
        LocalDate fechaInicioSemana,
        LocalDate fechsFinSemana,
        List<DatosDetalleOrdenCompraDetalle> detalles

) {
    public DatosDetalleOrdenCompra(OrdenCompra ordenCompraNueva) {
        this(
                ordenCompraNueva.getId(),
                ordenCompraNueva.getCliente().getNombre(),
                ordenCompraNueva.getContrato().getContrato(),
                ordenCompraNueva.getPartida(),
                ordenCompraNueva.getFechaInicioSemana(),
                ordenCompraNueva.getFechaFinSemana(),
                ordenCompraNueva.getDetalles().stream().map(
                        dn -> new DatosDetalleOrdenCompraDetalle(dn)
                ).collect(Collectors.toList())
        );
    }
}
