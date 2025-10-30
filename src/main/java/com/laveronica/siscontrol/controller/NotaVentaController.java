package com.laveronica.siscontrol.controller;

import com.laveronica.siscontrol.domain.notaventa.dto.DatosListarNota;
import com.laveronica.siscontrol.services.NotaVentaService;
import com.laveronica.siscontrol.domain.notaventa.dto.DatosDetalleNota;
import com.laveronica.siscontrol.domain.notaventa.dto.DatosRegistroNota;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/notaventas")
public class NotaVentaController {

    @Autowired
    private NotaVentaService notaVentaService;

    @PostMapping
    public ResponseEntity<DatosDetalleNota> registrarNota(@RequestBody @Valid DatosRegistroNota datos, UriComponentsBuilder uriComponentsBuilder) {
        DatosDetalleNota nuevaNotaVenta = notaVentaService.registrarNota(datos);
        var uri = uriComponentsBuilder.path("/notaventas/{id}").buildAndExpand(nuevaNotaVenta.id()).toUri();
        return ResponseEntity.created(uri).body(nuevaNotaVenta);
    }

    @GetMapping(path = {"","/"})
    public ResponseEntity<Page<DatosListarNota>> listaNotas(@PageableDefault(size = 9, sort = "fecha")Pageable paginacion){
        var page = notaVentaService.listarNotas(paginacion);
        return ResponseEntity.ok().body(page);
    }

}
