package com.laveronica.siscontrol.services;

import com.laveronica.siscontrol.domain.dias.Dia;
import com.laveronica.siscontrol.repositories.DiaRepository;
import com.laveronica.siscontrol.utils.helpers.DiaValidacionesHelper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DiaService {

    @Autowired
    private DiaRepository diaRepository;

    @Autowired
    private DiaValidacionesHelper diaValidacionesHelper;

    @Transactional
    public Dia registarOBuscarDia(LocalDate fecha){

        var dia = diaValidacionesHelper.diaExisteFecha(fecha);



        Dia nuevoDia = new Dia();
        nuevoDia.setFecha(fecha);
        nuevoDia.setActivo(true);

        return diaRepository.save(nuevoDia);

    }

}
