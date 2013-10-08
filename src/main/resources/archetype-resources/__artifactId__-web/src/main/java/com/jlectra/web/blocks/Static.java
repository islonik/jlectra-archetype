package com.jlectra.web.blocks;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * @author ANER0310
 * @date 9/27/13
 */
@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD })
@Retention(RUNTIME)
public @interface Static {
}
