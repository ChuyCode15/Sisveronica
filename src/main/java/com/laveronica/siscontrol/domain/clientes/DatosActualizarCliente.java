package com.laveronica.siscontrol.domain.clientes;

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
