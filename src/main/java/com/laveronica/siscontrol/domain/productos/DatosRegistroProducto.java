package com.laveronica.siscontrol.domain.productos;

import com.laveronica.siscontrol.domain.categoria.Categoria;
import com.laveronica.siscontrol.domain.valores.Partida;
import com.laveronica.siscontrol.domain.valores.UnidadMedida;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroProducto(

        @NotNull
        String nombre,

        @NotNull
        String partida,

        @NotNull
        Long categoriaId,

        @NotNull
        UnidadMedida unidadMedida,

        Double precioCompra,

        @NotNull
        Double precioVenta
) {
}

