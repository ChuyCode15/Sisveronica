package com.laveronica.siscontrol.controller;

import com.laveronica.siscontrol.domain.productos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/productos")
public class ProdutoController {

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<DatosDetalleProducto> registrar(@RequestBody @Valid DatosRegistroProducto datos, UriComponentsBuilder uriComponentsBuilder){
        Producto producto = productoService.registrarProducto(datos);
        var uri = uriComponentsBuilder.path("/productos/{id}").buildAndExpand(producto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleProducto(producto));
    }

}
