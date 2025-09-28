package com.laveronica.siscontrol.domain.clientes.dto;

public record DatosActualizarCliente(
        String nombre,
        String calle,
        Integer numero,
        String fraccionamiento,
        String cp,
        String municipio,
        String estado
) {
}
