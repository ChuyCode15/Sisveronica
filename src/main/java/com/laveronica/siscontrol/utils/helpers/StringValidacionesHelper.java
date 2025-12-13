package com.laveronica.siscontrol.utils.helpers;

import org.springframework.stereotype.Component;

@Component
public class StringValidacionesHelper {

    public String normalizadorcodigosPersitecia(String string){
        if ( string == null || string.isBlank()){
            return null;
        }
        String stringNormalizado = java.text.Normalizer
                .normalize(string, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toUpperCase()
                .trim()
                .replaceAll("[^a-z0-9\\s_-]", "")
                .replaceAll("\\s+", " ");

        return stringNormalizado;
    }

    public String normalizadoTextosPersistecia(String string){
        if (string == null || string.isBlank()){
            return null;
        }
        String stringNormalizado = string.toLowerCase().trim();
        return stringNormalizado;
    }


}
