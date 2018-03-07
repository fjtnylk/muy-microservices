package com.muy.microservice.user.repository.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.microservice.user.entity.UserDO;
import com.muy.microservice.user.mapper.UserMapper;
import com.muy.microservice.user.repository.IUserRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/3/1.
 */
@Repository
public class UserRepository
    extends ServiceImpl<UserMapper, UserDO> implements IUserRepository {

  /**
   * 添加目标用户.
   *
   * @param target
   * @return
   */
  @Override
  public boolean addUser(UserDO target) {
    return super.insert(target);
  }

  /**
   * 根据用户编号查询用户信息.
   *
   * @param userId
   * @return
   */
  @Override
  public UserDO queryUser(Long userId) {
    return super.selectOne(new EntityWrapper().where("user_id={0}", userId));
  }

  /**
   * 根据用户编号删除用户.
   *
   * @param userId
   * @return
   */
  @Override
  public boolean deleteUser(Long userId) {
    return super.deleteById(userId);
  }

  /**
   * 更新目标用户.
   *
   * @param target
   * @return
   */
  @Override
  public boolean updateUser(UserDO target) {
    return super.updateById(target);
  }
}
