package com.muy.web.b2b.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.muy.microservice.user.facade.IUserDubboService;
import com.muy.plugins.spring.boot.validation.annotation.ReturnValueValid;
import com.muy.web.b2b.service.IValidationService;
import com.muy.web.b2b.validator.UserAuthValidator;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/3/7.
 */
@Service
public class ValidationServiceImpl implements IValidationService {
  @Reference
  private IUserDubboService userDubboService;

  @ReturnValueValid(
      parameterTypes = String.class,
      constraintValidationBy = UserAuthValidator.class)
  @Override
  public boolean validationUser(String userName) {
    return userDubboService.hasUser(userName);
  }
}
