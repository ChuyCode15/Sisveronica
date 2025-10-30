package com.laveronica.siscontrol.domain.productos.dto;


import com.laveronica.siscontrol.domain.productos.Producto;

import java.math.BigDecimal;

public record DatosListarProductos(
        Long id,
        String nombre,
        String partida,
        String categoria,
        BigDecimal precioVenta

) {

    public DatosListarProductos(Producto producto){

        this(
                producto.getId(),
                producto.getNombre(),
                producto.getPartida().name(),
                producto.getCategoria().getNombre(),
                producto.getPrecioVenta()
        );

    }
}
