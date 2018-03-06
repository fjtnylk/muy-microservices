package com.muy.web.b2b.validator;

import com.muy.microservice.user.dto.LoadUserDto;
import com.muy.plugins.spring.boot.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by yanglikai on 2018/3/5.
 */
public class UserValidator implements ConstraintValidator<LoadUserDto> {
  @Override
  public boolean isValid(LoadUserDto value, ConstraintValidatorContext context) {
    if (value == null) {
      context.buildConstraintViolationWithTemplate("无效的用户.").addConstraintViolation();
      return false;
    }

    return true;
  }
}
