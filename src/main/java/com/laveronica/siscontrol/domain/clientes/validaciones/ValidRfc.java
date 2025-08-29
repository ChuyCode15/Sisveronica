package com.laveronica.siscontrol.domain.clientes.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RfcValidacion.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRfc {
    String message() default " ⚠️ RFC inválido: debe tener 13 caracteres alfanuméricos ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
