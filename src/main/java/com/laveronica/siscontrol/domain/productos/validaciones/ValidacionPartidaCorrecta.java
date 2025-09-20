package com.laveronica.siscontrol.domain.productos.validaciones;

import com.laveronica.siscontrol.domain.productos.DatosRegistroProducto;
import com.laveronica.siscontrol.domain.valores.Partida;
import com.laveronica.siscontrol.infra.exceptions.ex.RuleValidationException;
import org.springframework.stereotype.Component;


@Component
public class ValidacionPartidaCorrecta implements ValidadorDeProductos{

    @Override
    public void validar(DatosRegistroProducto datos) {
        try {
            Partida.valueOf(datos.partida());
        } catch (IllegalArgumentException ex) {
            throw new RuleValidationException("Partido no es valida " + datos.partida());
        }
    }
}
