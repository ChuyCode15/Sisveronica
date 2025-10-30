package com.laveronica.siscontrol.utils.helpers;

import com.laveronica.siscontrol.domain.productos.Producto;
import com.laveronica.siscontrol.repositories.ProductosRepository;
import com.laveronica.siscontrol.infra.exceptions.ex.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoValidacionesHelper {

    @Autowired
    private ProductosRepository productosRepository;

    public Producto encontrarProductoId(Long id){

        Producto producto = productosRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("⚠️ Producto No encontrado ID:" + id + " no existe o es invalido.")
                );
        return producto;
    }

}
