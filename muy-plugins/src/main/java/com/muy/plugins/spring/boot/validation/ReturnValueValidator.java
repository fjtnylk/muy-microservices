package com.muy.plugins.spring.boot.validation;

import com.muy.plugins.spring.boot.validation.annotation.ReturnValueValid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by yanglikai on 2018/3/6.
 */
public class ReturnValueValidator implements ConstraintValidator<ReturnValueValid, Object> {
  private static final Class<?>[] parameterTypes;
  private static final String METHOD_NAME = "isValid";

  private Class<?>[] clazzs = null;

  static {
    parameterTypes = new Class[]{Object.class, ConstraintValidatorContext.class};
  }

  @Override
  public void initialize(ReturnValueValid constraintAnnotation) {
    clazzs = constraintAnnotation.constraintValidationBy();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {

    for (Class<?> clazz : clazzs) {
      try {
        Object invoker = clazz.newInstance();

        Method method = clazz.getMethod(METHOD_NAME, parameterTypes);

        Object result = method.invoke(invoker, value, context);

        boolean isOK = (Boolean) result;
        if (isOK == false) {
          return false;
        }
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      } catch (InstantiationException e) {
        e.printStackTrace();
      }
    }

    return true;
  }
}
