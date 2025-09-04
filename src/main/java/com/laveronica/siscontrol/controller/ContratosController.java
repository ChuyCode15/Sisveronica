package com.laveronica.siscontrol.controller;

import com.laveronica.siscontrol.domain.contratos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratosController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ResponseEntity regitrar(@RequestBody @Valid DatosRegistroContrato datos, UriComponentsBuilder uriComponentsBuilder) {
        Contrato nuevoContrato = contratoService.registrarContrato(datos);
        var uri = uriComponentsBuilder.path("/contratos/{id}").buildAndExpand(nuevoContrato.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleContrato(nuevoContrato));
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<DatosDetalleContrato>> contratosLista() {
        List<DatosDetalleContrato> lista = contratoService.listarContratos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleContrato> contratoBuscarId(@PathVariable @Valid Long id) {
        DatosDetalleContrato contratoId = contratoService.buscarContratoId(id);
        return ResponseEntity.ok(contratoId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DatosDetalleContrato> actualizarContrato(@PathVariable Long id, @Valid @RequestBody DatosActualizarContrato datos){
        DatosDetalleContrato actualizarContrato = contratoService.actualizarContrato(id, datos);
        return ResponseEntity.ok(actualizarContrato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarContrato(@PathVariable Long id){
         contratoService.elimiarContrato(id);
    }

}
