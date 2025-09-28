package com.laveronica.siscontrol.domain.productos.validaciones;

import com.laveronica.siscontrol.domain.productos.dto.DatosRegistroProducto;
import com.laveronica.siscontrol.domain.productos.ProductosRepository;
import com.laveronica.siscontrol.infra.exceptions.ex.RuleValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionNombreNoExista implements ValidadorDeProductos {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public void validar(DatosRegistroProducto datos){
        if (productosRepository.existsByNombre(datos.nombre())){
            throw new RuleValidationException("El nombre del producto '"+datos.nombre()+"' ya se encuentra registrado");
        }
    }
}

