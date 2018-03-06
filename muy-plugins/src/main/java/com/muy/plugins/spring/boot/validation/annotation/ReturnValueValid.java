package com.muy.plugins.spring.boot.validation.annotation;

import com.muy.plugins.spring.boot.validation.ConstraintValidator;
import com.muy.plugins.spring.boot.validation.ReturnValueValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by yanglikai on 2018/3/2.
 */
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = ReturnValueValidator.class)
@Documented
public @interface ReturnValueValid {

  Class<?>[] parameterTypes();

  boolean required() default true;

  Class<? extends ConstraintValidator<?>>[] constraintValidationBy();

  String message() default "";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
