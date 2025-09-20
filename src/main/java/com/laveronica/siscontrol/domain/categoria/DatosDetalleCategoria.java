package com.laveronica.siscontrol.domain.categoria;

import com.laveronica.siscontrol.domain.valores.Partida;

public record DatosDetalleCategoria(

        Long id,
        String nombre,
        Partida partida
) {
    public DatosDetalleCategoria( Categoria categoria){
        this(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getPartida()
        );
    }
}
