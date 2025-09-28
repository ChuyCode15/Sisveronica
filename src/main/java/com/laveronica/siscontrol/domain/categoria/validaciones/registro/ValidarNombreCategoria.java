package com.laveronica.siscontrol.domain.categoria.validaciones.registro;

import com.laveronica.siscontrol.domain.categoria.CategoriaRepository;
import com.laveronica.siscontrol.domain.categoria.dto.DatosRegistroCategoria;
import com.laveronica.siscontrol.infra.exceptions.ex.RuleValidationException;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidarNombreCategoria implements ValiadacionesRegistarCategorias {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void validar(DatosRegistroCategoria datos) {
        if (categoriaRepository.existsByNombre(datos.nombre())){
            throw new RuleValidationException("ya existe una categoria registrada con un nombre: "+ datos.nombre());
        }
    }
}