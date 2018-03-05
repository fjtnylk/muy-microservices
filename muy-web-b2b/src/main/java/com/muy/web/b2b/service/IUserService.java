package com.muy.web.b2b.service;

import com.muy.microservice.user.dto.LoadUserDto;
import com.muy.microservice.user.query.CreateUserQuery;
import com.muy.microservice.user.query.DeleteUserQuery;
import com.muy.microservice.user.query.LoadUserQuery;
import com.muy.microservice.user.query.UpdateUserQuery;

/**
 * Created by yanglikai on 2018/3/2.
 */
public interface IUserService {


  /**
   * 创建用户.
   *
   * @param query
   * @return
   */
  boolean createUser(CreateUserQuery query);

  /**
   * 删除用户.
   *
   * @param query
   * @return
   */
  boolean deleteUser(DeleteUserQuery query);

  /**
   * 更新用户.
   *
   * @param query
   * @return
   */
  boolean updateUser(UpdateUserQuery query);

  /**
   * 加载用户.
   *
   * @param query
   * @return
   */
  LoadUserDto loadUser(LoadUserQuery query);
}
