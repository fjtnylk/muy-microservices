package com.muy.microservice.user.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.microservice.user.entity.UserDO;

/**
 * Created by yanglikai on 2018/3/1.
 */
public interface IUserRepository extends IService<UserDO> {

  /**
   * 添加目标用户.
   *
   * @param target
   * @return
   */
  boolean addUser(UserDO target);

  /**
   * 根据用户编号查询用户信息.
   *
   * @param userId
   * @return
   */
  UserDO queryUser(Long userId);

  /**
   * 根据用户编号删除用户.
   *
   * @param userId
   * @return
   */
  boolean deleteUser(Long userId);

  /**
   * 更新目标用户.
   *
   * @param target
   * @return
   */
  boolean updateUser(UserDO target);
}
