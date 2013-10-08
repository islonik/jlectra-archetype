package com.jlectra.utils.validations.impl;

import com.jlectra.utils.validations.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Nikita Lipatov
 * Date: 21.07.12
 * Time: 15:23
 */
public class PhoneValidator implements ConstraintValidator<Phone, Object> {

    public void initialize(Phone phoneAnnotation) {

    }

    public boolean isValid(Object object, ConstraintValidatorContext context) {
		if(object == null) return true;

        String phone = object.toString();
        phone = phone.replaceAll("\\+", "");
        phone = phone.replaceAll("-", "");
        phone = phone.replaceAll("\\(", "");
        phone = phone.replaceAll("\\)", "");
        phone = phone.replaceAll(" ", "");
        Pattern pattern = Pattern.compile("[0-9]{6,11}");
        Matcher matcher = pattern.matcher(phone);
        while(matcher.matches()){
            return true;
        }
        return false;
    }
}
