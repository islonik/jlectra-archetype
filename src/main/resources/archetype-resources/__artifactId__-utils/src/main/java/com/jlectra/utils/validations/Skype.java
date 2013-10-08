package com.jlectra.utils.validations;

import com.jlectra.utils.validations.impl.SkypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Nikita Lipatov
 * Date: 20.07.12
 * Time: 23:40
 */

@Target({java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SkypeValidator.class)
@Documented
public @interface Skype {

    String message() default "Skype address not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
