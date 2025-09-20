package com.laveronica.siscontrol.domain.productos.validaciones;

import com.laveronica.siscontrol.domain.categoria.CategoriaRepository;
import com.laveronica.siscontrol.domain.productos.DatosRegistroProducto;
import com.laveronica.siscontrol.domain.productos.ProductosRepository;
import com.laveronica.siscontrol.infra.exceptions.ex.RuleValidationException;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidacionCategoria implements ValidadorDeProductos  {

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void validar(DatosRegistroProducto datos){

        var categoria = categoriaRepository.findById(datos.categoriaId())
                .orElseThrow();

        if(!categoriaRepository.existsById(categoria)){
            throw new RuleValidationException("La categoria indicada no existe");
        } else if (categoriaRepository.findByIdAndActivoTrue(categoria)){

        }
        {

        }
    }

}
