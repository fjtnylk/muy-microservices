package com.muy.plugins.spring.boot.validation;

import javax.validation.ConstraintValidatorContext;

/**
 * Created by yanglikai on 2018/3/6.
 */
public interface ConstraintValidator<T> {

  boolean isValid(T value, ConstraintValidatorContext context);
}
