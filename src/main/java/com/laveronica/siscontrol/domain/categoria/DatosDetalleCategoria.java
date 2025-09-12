package com.laveronica.siscontrol.domain.categoria;

import com.laveronica.siscontrol.domain.valores.Partida;
import jakarta.validation.constraints.NotNull;

public record DatosDetalleCategoria(

        @NotNull
        String nombre,
        Partida partida
) {
}
