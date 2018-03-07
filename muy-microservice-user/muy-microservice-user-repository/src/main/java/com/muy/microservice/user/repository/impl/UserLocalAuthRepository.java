package com.muy.microservice.user.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.microservice.user.entity.UserLocalAuthDO;
import com.muy.microservice.user.mapper.UserLocalAuthMapper;
import com.muy.microservice.user.repository.IUserLocalAuthRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/3/7.
 */
@Repository
public class UserLocalAuthRepository
    extends ServiceImpl<UserLocalAuthMapper, UserLocalAuthDO> implements IUserLocalAuthRepository {

  /**
   * 添加用户本地认证信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean addLocalAuth(UserLocalAuthDO target) {
    return super.insert(target);
  }

  /**
   * 查询用户本地认证信息.
   *
   * @param userName
   * @return
   */
  @Override
  public UserLocalAuthDO queryLocalAuth(String userName) {
    return super.selectOne(new EntityWrapper<UserLocalAuthDO>().where("user_name={0}", userName));
  }

  /**
   * 删除用户本地认证信息.
   *
   * @param userId
   * @return
   */
  @Override
  public boolean deleteLocalAuth(Long userId) {
    return super.deleteById(userId);
  }

  /**
   * 更新用户本地认证信息.
   *
   * @param target
   * @return
   */
  @Override
  public boolean updateLocalAuth(UserLocalAuthDO target) {
    return super.updateById(target);
  }
}
