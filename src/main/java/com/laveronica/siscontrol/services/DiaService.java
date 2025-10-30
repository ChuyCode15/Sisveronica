package com.laveronica.siscontrol.services;

import com.laveronica.siscontrol.domain.dias.Dia;
import com.laveronica.siscontrol.repositories.DiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DiaService {

    @Autowired
    private DiaRepository diaRepository;

    @Transactional
    public Dia registarOBuscarDia(LocalDate fecha){

        Optional<Dia> diaExiste = diaRepository.findByFecha(fecha);

        if (diaExiste.isPresent()){
            return diaExiste.get();
        }

        Dia nuevoDia = new Dia();
        nuevoDia.setFecha(fecha);
        nuevoDia.setActivo(true);

        return diaRepository.save(nuevoDia);

    }

}
