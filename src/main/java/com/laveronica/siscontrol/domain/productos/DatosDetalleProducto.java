package com.laveronica.siscontrol.domain.productos;

import com.laveronica.siscontrol.domain.categoria.Categoria;
import com.laveronica.siscontrol.domain.valores.Partida;
import com.laveronica.siscontrol.domain.valores.UnidadMedida;
import jakarta.validation.constraints.NotNull;

import javax.swing.*;


public record DatosDetalleProducto(

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
                producto.getNombre(),
                producto.getPartida(),
                producto.getCategoria().getId(),
                producto.getUnidadMedida().name(),
                producto.getPrecioCompra(),
                producto.getPrecioVenta()
        );
    }


}
