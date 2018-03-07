package com.muy.microservice.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.muy.microservice.user.biz.UserBiz;
import com.muy.microservice.user.dto.RegisterUserDto;
import com.muy.microservice.user.entity.UserLocalAuthDO;
import com.muy.microservice.user.facade.IUserDubboService;
import com.muy.microservice.user.query.RegisterUserQuery;
import com.muy.microservice.user.repository.IUserLocalAuthRepository;
import com.muy.microservice.user.repository.IUserRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/3/1.
 */
@Component
@Service(interfaceClass = IUserDubboService.class, timeout = 10000)
public class UserDubboServiceImpl implements IUserDubboService {
  @Resource
  private UserBiz userBiz;
  @Resource
  private IUserLocalAuthRepository userLocalAuthRepository;
  @Resource
  private IUserRepository userRepository;

  /**
   * 用户注册.
   *
   * @param query
   * @return
   */
  @Override
  public RegisterUserDto register(RegisterUserQuery query) {
    return userBiz.register(query);
  }

  /**
   * 用户验证.
   *
   * @param userName
   * @return
   */
  @Override
  public boolean hasUser(String userName) {
    UserLocalAuthDO userLocalAuth = userLocalAuthRepository.queryLocalAuth(userName);
    return userLocalAuth != null;
  }
}