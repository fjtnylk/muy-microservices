package com.muy.microservice.user.facade;

import com.muy.microservice.user.dto.RegisterUserDto;
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
   * 用户验证.
   *
   * @param userName
   * @return
   */
  boolean hasUser(String userName);
}
