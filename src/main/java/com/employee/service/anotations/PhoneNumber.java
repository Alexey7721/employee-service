package com.employee.service.anotations;

import com.employee.service.anotations.impl.PhoneNumberValid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValid.class)
public @interface PhoneNumber {

    public String message() default "Is not phone number value";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
