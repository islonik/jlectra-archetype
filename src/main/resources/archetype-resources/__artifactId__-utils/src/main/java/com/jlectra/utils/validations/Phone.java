package com.jlectra.utils.validations;

import com.jlectra.utils.validations.impl.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Nikita Lipatov
 * Date: 21.07.12
 * Time: 15:17
 */
@Target({java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
@Documented
public @interface Phone {

    String message() default "Phone not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
