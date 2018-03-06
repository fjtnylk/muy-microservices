package com.muy.web.b2b.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.muy.microservice.user.dto.LoadUserDto;
import com.muy.microservice.user.facade.IUserDubboService;
import com.muy.microservice.user.query.CreateUserQuery;
import com.muy.microservice.user.query.DeleteUserQuery;
import com.muy.microservice.user.query.LoadUserQuery;
import com.muy.microservice.user.query.UpdateUserQuery;
import com.muy.plugins.spring.boot.validation.annotation.ReturnValueValid;
import com.muy.web.b2b.service.IUserService;
import com.muy.web.b2b.validator.UserNameValidator;
import com.muy.web.b2b.validator.UserValidator;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2018/3/2.
 */
@Service
public class UserServiceImpl implements IUserService {
  @Reference
  private IUserDubboService userDubboService;

  /**
   * 创建用户.
   *
   * @param query
   * @return
   */
  @Override
  public boolean createUser(CreateUserQuery query) {
    return userDubboService.createUser(query);
  }

  /**
   * 删除用户.
   *
   * @param query
   * @return
   */
  @Override
  public boolean deleteUser(DeleteUserQuery query) {
    return userDubboService.deleteUser(query);
  }

  /**
   * 更新用户.
   *
   * @param query
   * @return
   */
  @Override
  public boolean updateUser(UpdateUserQuery query) {
    return userDubboService.updateUser(query);
  }

  /**
   * 加载用户.
   *
   * @param query
   * @return
   */
  @ReturnValueValid(
      parameterTypes = {LoadUserQuery.class},
      constraintValidationBy = {UserValidator.class, UserNameValidator.class})
  @Override
  public LoadUserDto loadUser(LoadUserQuery query) {
    return userDubboService.loadUser(query);
  }
}
