package com.muy.web.b2b.validator;

import com.muy.microservice.user.dto.LoadUserDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by yanglikai on 2018/3/5.
 */
public class LoadUserValidator implements ConstraintValidator<LoadUserValid, LoadUserDto> {

  @Override
  public boolean isValid(LoadUserDto value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }

    return true;
  }
}
