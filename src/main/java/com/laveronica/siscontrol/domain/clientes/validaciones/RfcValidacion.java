package com.laveronica.siscontrol.domain.clientes.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RfcValidacion implements ConstraintValidator<ValidRfc, String> {

    @Override
    public boolean isValid(String rfc, ConstraintValidatorContext context){
        if (rfc == null) return false;
        String rfcLimpio = rfc.trim().toUpperCase();
        return rfcLimpio.matches("^[A-Z0-9]{13}$");
    }

}
