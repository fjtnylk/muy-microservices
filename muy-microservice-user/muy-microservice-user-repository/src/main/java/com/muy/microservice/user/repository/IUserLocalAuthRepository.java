package com.muy.microservice.user.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.microservice.user.entity.UserLocalAuthDO;

/**
 * Created by yanglikai on 2018/3/7.
 */
public interface IUserLocalAuthRepository extends IService<UserLocalAuthDO> {

  /**
   * 添加用户本地认证信息.
   *
   * @param target
   * @return
   */
  boolean addLocalAuth(UserLocalAuthDO target);

  /**
   * 查询用户本地认证信息.
   *
   * @param userName
   * @return
   */
  UserLocalAuthDO queryLocalAuth(String userName);

  /**
   * 删除用户本地认证信息.
   *
   * @param userId
   * @return
   */
  boolean deleteLocalAuth(Long userId);

  /**
   * 更新用户本地认证信息.
   *
   * @param target
   * @return
   */
  boolean updateLocalAuth(UserLocalAuthDO target);
}
