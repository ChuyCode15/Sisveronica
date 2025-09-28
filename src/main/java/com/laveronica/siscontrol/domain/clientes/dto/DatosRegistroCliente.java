package com.laveronica.siscontrol.domain.clientes.dto;


import com.laveronica.siscontrol.domain.clientes.validaciones.ValidRfc;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record DatosRegistroCliente(

        @NotBlank(message = "⚠️ Nombre es obligatorio")
        @Size(max = 50, message = "⚠️ Nombre no puede tener más de 50 caracteres")
        String nombre,

        @ValidRfc
        String rfc,

        String calle,

        Integer numero,

        String fraccionamiento,

        @NotBlank(message = "⚠️ Código postal es obligatorio")
        @Pattern(regexp = "\\d{5}", message = "⚠️ Código postal inválido: debe tener 5 dígitos")
        String cp,

        String municipio,

        String estado
) {


}
