package com.laveronica.siscontrol.domain.categoria.validaciones.categoria;

import com.laveronica.siscontrol.domain.categoria.CategoriaRepository;
import com.laveronica.siscontrol.domain.categoria.dto.DatosDetalleCategoria;
import com.laveronica.siscontrol.infra.exceptions.ex.RuleValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarExisteCategoria implements ValiadacionesCategorias {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void validar(DatosDetalleCategoria datos) {
        if (!categoriaRepository.existsById(datos.id())){
            throw new RuleValidationException("La categoria no existe seleccionada");
        }
    }
}