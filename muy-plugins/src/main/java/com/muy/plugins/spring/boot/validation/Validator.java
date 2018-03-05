package com.muy.plugins.spring.boot.validation;

import java.lang.reflect.Method;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

/**
 * Created by yanglikai on 2018/3/5.
 */
public class Validator {
  private static final ExecutableValidator executableValidator;
  private static final javax.validation.Validator validator;

  static {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    executableValidator = validatorFactory.getValidator().forExecutables();

    validator = validatorFactory.getValidator();
  }

  public static <T> Set<ConstraintViolation<T>> validateParamters(T object, Method method, Object[] parameterValues) {
    return executableValidator.validateParameters(object, method, parameterValues);
  }

  public static Set<ConstraintViolation<Object>> validateReturnValue(Object object, Method method, Object returnValue) {
    return executableValidator.validateReturnValue(object, method, returnValue);
  }

  public static <T> Set<ConstraintViolation<T>> validateProperty(T object, String propertyName) {
    return validator.validateProperty(object, propertyName);
  }

  public static Set<ConstraintViolation<Object>> validate(Object object) {
    return validator.validate(object);
  }
}
