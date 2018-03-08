package com.muy.web.b2b.service;

import com.muy.microservice.user.dto.LoadUserDto;
import com.muy.microservice.user.dto.LoginUserDto;
import com.muy.microservice.user.dto.RegisterUserDto;
import com.muy.web.b2b.query.B2BCreateUserQuery;
import com.muy.web.b2b.query.B2BDeleteUserQuery;
import com.muy.web.b2b.query.B2BLoadUserQuery;
import com.muy.web.b2b.query.B2BLoginUserQuery;
import com.muy.web.b2b.query.B2BRegisterUserQuery;
import com.muy.web.b2b.query.B2BUpdateUserQuery;

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
  boolean createUser(B2BCreateUserQuery query);

  /**
   * 删除用户.
   *
   * @param query
   * @return
   */
  boolean deleteUser(B2BDeleteUserQuery query);

  /**
   * 更新用户.
   *
   * @param query
   * @return
   */
  boolean updateUser(B2BUpdateUserQuery query);

  /**
   * 加载用户.
   *
   * @param query
   * @return
   */
  LoadUserDto loadUser(B2BLoadUserQuery query);

  /**
   * 用户注册.
   *
   * @param query
   * @return
   */
  RegisterUserDto register(B2BRegisterUserQuery query);

  /**
   * 初始化用户随机数.
   *
   * @return
   */
  boolean initUserRandom();

  /**
   * 登录验证.
   *
   * @param query
   * @return
   */
  LoginUserDto loginAuth(B2BLoginUserQuery query);
}
