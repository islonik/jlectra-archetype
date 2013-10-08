package com.jlectra.utils.validations.impl;

import com.jlectra.utils.validations.Skype;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * User: Nikita Lipatov
 * Date: 20.07.12
 * Time: 23:49
 */
public class SkypeValidator implements ConstraintValidator<Skype, Object> {

    public void initialize(Skype skypeAnnotation) {

    }

    public boolean isValid(Object object, ConstraintValidatorContext context) {
		if(object == null) return true;

        if(object.toString().contains(" ")) {
            return false;
        }
        return true;
    }
}
