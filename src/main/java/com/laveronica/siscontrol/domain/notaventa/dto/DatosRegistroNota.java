package com.laveronica.siscontrol.domain.notaventa.dto;

import com.laveronica.siscontrol.domain.notaventadetalle.dto.NotaVentaDetalleRegistro;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosRegistroNota(

        @NotNull
        Long clienteId,
        String partida,
        List<NotaVentaDetalleRegistro> detalles


) {
}
