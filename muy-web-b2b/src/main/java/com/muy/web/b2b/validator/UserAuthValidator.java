package com.muy.web.b2b.validator;

import com.muy.plugins.spring.boot.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by yanglikai on 2018/3/7.
 */
public class UserAuthValidator implements ConstraintValidator<Boolean> {
  @Override
  public boolean isValid(Boolean value, ConstraintValidatorContext context) {
    if (value == true) {
      context.buildConstraintViolationWithTemplate("用户已存在.").addConstraintViolation();
      return false;
    }

    return true;
  }
}
