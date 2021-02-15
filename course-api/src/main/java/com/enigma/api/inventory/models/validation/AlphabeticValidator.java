package com.enigma.api.inventory.models.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphabeticValidator implements ConstraintValidator<Alphabetic, String> {
    @Override
    public boolean isValid(String t, ConstraintValidatorContext constraintValidatorContext) {
        return t.matches("[A-Za-z]*"); //regex101.com
    }
}
