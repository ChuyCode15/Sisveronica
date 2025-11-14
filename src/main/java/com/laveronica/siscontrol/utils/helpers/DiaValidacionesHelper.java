package com.laveronica.siscontrol.utils.helpers;

import com.laveronica.siscontrol.domain.dias.Dia;
import com.laveronica.siscontrol.infra.exceptions.ex.ResourceNotFoundException;
import com.laveronica.siscontrol.repositories.DiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DiaValidacionesHelper {

    @Autowired
    private DiaRepository diaRepository;

    public Dia diaExisteFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new ResourceNotFoundException("No se ingreso una fecha correcta o valida: " + fecha);
        }

        Dia diaEncontrado = diaRepository.findByFecha(fecha)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No se encontro nungun registro dia con la fecha ingresada: " + fecha)
                );
        return diaEncontrado;

    }

}
