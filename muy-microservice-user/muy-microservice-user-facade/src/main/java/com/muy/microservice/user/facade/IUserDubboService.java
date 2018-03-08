package com.muy.microservice.user.facade;

import com.muy.microservice.user.dto.LoginUserDto;
import com.muy.microservice.user.dto.RegisterUserDto;
import com.muy.microservice.user.query.LoginUserQuery;
import com.muy.microservice.user.query.RegisterUserQuery;

/**
 * Created by yanglikai on 2018/3/1.
 */
public interface IUserDubboService {

  /**
   * 用户注册.
   *
   * @param query
   * @return
   */
  RegisterUserDto register(RegisterUserQuery query);

  /**
   * 登录认证.
  *
   * @param query
   * @return
   */
  LoginUserDto loginAuth(LoginUserQuery query);

  /**
   * 用户验证.
   *
   * @param userName
   * @return
   */
  boolean hasUser(String userName);
}
