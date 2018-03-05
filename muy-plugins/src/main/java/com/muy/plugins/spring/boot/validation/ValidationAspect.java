package com.muy.plugins.spring.boot.validation;

import com.muy.plugins.spring.boot.validation.annotation.ParameterValid;
import com.muy.plugins.spring.boot.validation.annotation.ReturnValueValid;
import java.lang.reflect.Method;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

/**
 * Created by yanglikai on 2018/3/5.
 */
@Aspect
@Order(0)
public class ValidationAspect {

  /**
   * 执行前
   *
   * @param joinPoint
   * @param paramterValid
   */
  @Before(value = "@annotation(paramterValid)")
  public void before(JoinPoint joinPoint, ParameterValid paramterValid) {
    if (paramterValid.required() == false) {
      return;
    }

    Object[] args = joinPoint.getArgs();
    for (Object arg : args) {
      if (arg.getClass().getName().equals(paramterValid.target().getName())) {
        Set<ConstraintViolation<Object>> validateResult = Validator.validate(arg);
        for (ConstraintViolation<Object> el : validateResult) {
          throw new ValidationException(el.getMessage());
        }
      }
    }
  }

  /**
   * 返回
   *
   * @param joinPoint
   * @param returnValueValid
   * @param result
   */
  @AfterReturning(value = "@annotation(returnValueValid)", returning = "result")
  public void afterReturning(JoinPoint joinPoint, ReturnValueValid returnValueValid, Object result) {
    if (returnValueValid.required() == false) {
      return;
    }

    Object object = joinPoint.getTarget();

    String methodName = joinPoint.getSignature().getName();

    Method method = null;
    try {
      method = object.getClass().getMethod(methodName, returnValueValid.parameterTypes());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

    Set<ConstraintViolation<Object>> validateResult = Validator.validateReturnValue(object, method, result);
    for (ConstraintViolation<Object> el : validateResult) {
      throw new ValidationException(el.getMessage());
    }
  }
}
