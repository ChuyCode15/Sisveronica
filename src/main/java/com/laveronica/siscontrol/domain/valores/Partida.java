package com.laveronica.siscontrol.domain.valores;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Partida {
    ABARROTES,
    CARNES,
    LACTEOS,
    FRUTASYVERDURAS,
    VARIOS;

    @JsonCreator
    public static Partida fromString(String value) {
        return Partida.valueOf(value.toUpperCase());
    }
}

