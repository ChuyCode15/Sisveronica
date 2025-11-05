package com.laveronica.siscontrol.utils.helpers;

import com.laveronica.siscontrol.domain.productos.Producto;
import com.laveronica.siscontrol.repositories.ProductosRepository;
import com.laveronica.siscontrol.infra.exceptions.ex.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoValidacionesHelper {

    @Autowired
    private ProductosRepository productosRepository;

    @Transactional
    public Producto encontrarProductoId(Long id) {

        Producto producto = productosRepository.findByIdAndActivoTrue(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("⚠️ Producto No encontrado ID:" + id + " no existe o es invalido.")
                );
        return producto;
    }

    @Transactional
    public Producto encontrarProductoNombre(String producto) {

        Producto productoEncontrado = productosRepository.findByNombreAndActivoTrue(producto)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No existe un producto valido con ese nombre: " + producto + ".")
                );
        return productoEncontrado;
    }


}
