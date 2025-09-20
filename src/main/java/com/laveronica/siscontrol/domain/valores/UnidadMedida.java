package com.laveronica.siscontrol.domain.valores;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UnidadMedida {
    KILO,
    LITRO,
    PIEZA,
    PAQUETE;

    @JsonCreator
    public static UnidadMedida fromString(String value){
        return UnidadMedida.valueOf(value.toUpperCase());
    }
}
