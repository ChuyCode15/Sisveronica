package com.laveronica.siscontrol.utils.helpers;

import com.laveronica.siscontrol.domain.valores.Partida;
import com.laveronica.siscontrol.infra.exceptions.ex.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class PartidaValidacionesHelper {

    public Partida validaPartidaExista(String partida) {

        if (partida == null || partida.isBlank()) {
            throw new ResourceNotFoundException("La partida es requerida y no puede estar vacía.");
        }
        String partidaNormalizada = partida.toUpperCase().trim();
        Partida partidaEnum;
        try {
            partidaEnum = Partida.valueOf(partidaNormalizada);
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException("La partida '" + partidaNormalizada + "' no es una partida válida del sistema.");
        }
        return partidaEnum;
    }
}
