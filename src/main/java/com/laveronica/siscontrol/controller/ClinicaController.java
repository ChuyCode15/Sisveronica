package com.laveronica.siscontrol.controller;

import com.laveronica.siscontrol.domain.clientes.DatosRegistroClinica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clinicas")

public class ClinicaController {

    //@Autowired
    //private ClinicaService clinicaService;

    @PostMapping
    public ResponseEntity registrar(@RequestBody DatosRegistroClinica datos, UriComponentsBuilder uriComponentsBuilder){
        //Clinica nuevaClinica = clinicaService.registrarClinica(datos);
        return ResponseEntity.ok("Todo ok hast ahora ");
    }

}
