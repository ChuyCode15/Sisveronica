package com.laveronica.siscontrol.domain.productos.dto;

import com.laveronica.siscontrol.domain.valores.Partida;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DatosActualizarProducto(


        String nombre,

        String partida,

        Long categoriaId,

        String unidadMedida,

        BigDecimal precioCompra,

        BigDecimal precioVenta

) {
}
