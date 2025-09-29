package com.laveronica.siscontrol.domain.productos.dto;

import com.laveronica.siscontrol.domain.productos.Producto;
import com.laveronica.siscontrol.domain.valores.Partida;
import jakarta.validation.constraints.NotNull;


public record DatosDetalleProducto(

        @NotNull
        Long id,

        @NotNull
        String nombre,

        @NotNull
        Partida partida,

        @NotNull
        Long categoria,

        @NotNull
        String unidadMedida,

        Double precioCompra,

        @NotNull
        Double precioVenta



) {

    public DatosDetalleProducto(Producto producto){
        this(
                producto.getId(),
                producto.getNombre(),
                producto.getPartida(),
                producto.getCategoria().getId(),
                producto.getUnidadMedida().name(),
                producto.getPrecioCompra(),
                producto.getPrecioVenta()
        );
    }


}
