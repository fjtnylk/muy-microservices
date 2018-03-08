package com.muy.microservice.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.muy.crypto.encryptor.EncryptorsUtils;
import com.muy.microservice.user.biz.UserBiz;
import com.muy.microservice.user.dto.LoginUserDto;
import com.muy.microservice.user.dto.RegisterUserDto;
import com.muy.microservice.user.entity.UserLocalAuthDO;
import com.muy.microservice.user.facade.IUserDubboService;
import com.muy.microservice.user.query.LoginUserQuery;
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
   * 登录认证.
   *
   * @param query
   * @return
   */
  @Override
  public LoginUserDto loginAuth(LoginUserQuery query) {
    String userName = query.getUserName();
    String rawPassword = query.getPassword();

    UserLocalAuthDO userLocalAuth = userLocalAuthRepository.queryLocalAuth(userName);
    if (userLocalAuth == null) {
      return LoginUserDto.empty();
    }

    String salt = userLocalAuth.getSalt();
    String original = userLocalAuth.getPassword();

    String hashPassword = EncryptorsUtils.sha256(EncryptorsUtils.sha256(rawPassword) + salt);

    boolean isValid = EncryptorsUtils.slowEquals(original, hashPassword);
    if (isValid == false) {
      return LoginUserDto.empty();
    }

    long userId = userLocalAuth.getUserId();
    return LoginUserDto.creaet().withUserId(userId);
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