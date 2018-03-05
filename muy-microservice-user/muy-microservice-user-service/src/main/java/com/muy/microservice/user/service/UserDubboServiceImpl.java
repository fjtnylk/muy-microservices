package com.muy.microservice.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.muy.microservice.user.dto.LoadUserDto;
import com.muy.microservice.user.entity.UserDO;
import com.muy.microservice.user.facade.IUserDubboService;
import com.muy.microservice.user.query.CreateUserQuery;
import com.muy.microservice.user.query.DeleteUserQuery;
import com.muy.microservice.user.query.LoadUserQuery;
import com.muy.microservice.user.query.UpdateUserQuery;
import com.muy.microservice.user.repository.IUserRepository;
import com.muy.misc.ModelUtils;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/3/1.
 */
@Component
@Service(interfaceClass = IUserDubboService.class, timeout = 10000)
public class UserDubboServiceImpl implements IUserDubboService {
  @Resource
  private IUserRepository userRepository;

  /**
   * 创建用户.
   *
   * @param query
   * @return
   */
  @Override
  public boolean createUser(CreateUserQuery query) {
    UserDO target = ModelUtils.parse(query, UserDO.class);

    return userRepository.addUser(target);
  }

  /**
   * 删除用户.
   *
   * @param query
   * @return
   */
  @Override
  public boolean deleteUser(DeleteUserQuery query) {
    return userRepository.deleteUser(query.getUserId());
  }

  /**
   * 更新用户.
   *
   * @param query
   * @return
   */
  @Override
  public boolean updateUser(UpdateUserQuery query) {
    UserDO target = ModelUtils.parse(query, UserDO.class);
    target.setUpdateTime(new Date());

    return userRepository.updateUser(target);
  }

  /**
   * 加载用户.
   *
   * @param query
   * @return
   */
  @Override
  public LoadUserDto loadUser(LoadUserQuery query) {
    UserDO source = userRepository.queryUser(query.getUserId());

    return ModelUtils.parse(source, LoadUserDto.class);
  }
}