package com.muy.microservice.user.biz;

import com.muy.crypto.encryptor.EncryptorsUtils;
import com.muy.microservice.user.dto.RegisterUserDto;
import com.muy.microservice.user.entity.UserDO;
import com.muy.microservice.user.entity.UserLocalAuthDO;
import com.muy.microservice.user.query.RegisterUserQuery;
import com.muy.microservice.user.repository.IUserLocalAuthRepository;
import com.muy.microservice.user.repository.IUserRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanglikai on 2018/3/7.
 */
@Component
public class UserBiz {
  @Resource
  private IUserRepository userRepository;
  @Resource
  private IUserLocalAuthRepository userLocalAuthRepository;

  /**
   * 注册用户.
   *
   * @param query
   * @return
   */
  @Transactional
  public RegisterUserDto register(RegisterUserQuery query) {
    String userName = query.getUserName();
    String password = query.getPassword();
    String salt = EncryptorsUtils.generateKey();
    String hashPassword = EncryptorsUtils.sha256(EncryptorsUtils.sha256(password) + salt);

    /* 存储用户认证信息 */
    UserLocalAuthDO userLocalAuth = new UserLocalAuthDO();
    userLocalAuth.setUserName(userName);
    userLocalAuth.setPassword(hashPassword);
    userLocalAuth.setSalt(salt);
    userLocalAuthRepository.addLocalAuth(userLocalAuth);
    long userId = userLocalAuth.getId();

    /* 存储用户基本信息 */
    UserDO user = new UserDO();
    user.setUserId(userId);
    user.setUserName(userName);
    userRepository.addUser(user);

    return new RegisterUserDto(userId);
  }
}
