package com.laveronica.siscontrol.domain.clientes;


public record DatosDetalleCliente(
        String nombre,
        String rfc,
        String calle,
        Integer numero,
        String fraccionamiento,
        String cp,
        String municipio,
        String estado
) {
    public DatosDetalleCliente(Cliente cliente){
        this(
                cliente.getNombre(),
                cliente.getRfc(),
                cliente.getCalle(),
                cliente.getNumero(),
                cliente.getFraccionamiento(),
                cliente.getCp(),
                cliente.getMunicipio(),
                cliente.getEstado()
        );
    }
}
