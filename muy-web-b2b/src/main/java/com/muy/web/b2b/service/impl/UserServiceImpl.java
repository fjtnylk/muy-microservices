package com.muy.web.b2b.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.muy.microservice.user.dto.LoadUserDto;
import com.muy.microservice.user.dto.RegisterUserDto;
import com.muy.microservice.user.facade.IUserDubboService;
import com.muy.microservice.user.facade.IUserManageService;
import com.muy.plugins.spring.boot.validation.annotation.ReturnValueValid;
import com.muy.web.b2b.query.B2BCreateUserQuery;
import com.muy.web.b2b.query.B2BDeleteUserQuery;
import com.muy.web.b2b.query.B2BLoadUserQuery;
import com.muy.web.b2b.query.B2BRegisterUserQuery;
import com.muy.web.b2b.query.B2BUpdateUserQuery;
import com.muy.web.b2b.service.IUserService;
import com.muy.web.b2b.service.IValidationService;
import com.muy.web.b2b.validator.UserNameValidator;
import com.muy.web.b2b.validator.UserValidator;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/3/2.
 */
@Service
public class UserServiceImpl implements IUserService {
  @Reference
  private IUserDubboService userDubboService;
  @Reference
  private IUserManageService userManageService;

  @Resource
  private IValidationService validationService;

  /**
   * 创建用户.
   *
   * @param query
   * @return
   */
  @Override
  public boolean createUser(B2BCreateUserQuery query) {
    return userManageService.createUser(query);
  }

  /**
   * 删除用户.
   *
   * @param query
   * @return
   */
  @Override
  public boolean deleteUser(B2BDeleteUserQuery query) {
    return userManageService.deleteUser(query);
  }

  /**
   * 更新用户.
   *
   * @param query
   * @return
   */
  @Override
  public boolean updateUser(B2BUpdateUserQuery query) {
    return userManageService.updateUser(query);
  }

  /**
   * 加载用户.
   *
   * @param query
   * @return
   */
  @ReturnValueValid(
      parameterTypes = {B2BLoadUserQuery.class},
      constraintValidationBy = {UserValidator.class, UserNameValidator.class})
  @Override
  public LoadUserDto loadUser(B2BLoadUserQuery query) {
    return userManageService.loadUser(query);
  }

  /**
   * 用户注册.
   *
   * @param query
   * @return
   */
  @Override
  public RegisterUserDto register(B2BRegisterUserQuery query) {
    String userName = query.getUserName();

    /* 用户认证 */
    validationService.validationUser(userName);

    /* 用户注册 */
    return userDubboService.register(query);
  }
}
