package com.muy.microservice.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.muy.microservice.user.dto.LoadUserDto;
import com.muy.microservice.user.entity.UserDO;
import com.muy.microservice.user.entity.UserRandomDO;
import com.muy.microservice.user.facade.IUserManageService;
import com.muy.microservice.user.query.CreateUserQuery;
import com.muy.microservice.user.query.DeleteUserQuery;
import com.muy.microservice.user.query.LoadUserQuery;
import com.muy.microservice.user.query.UpdateUserQuery;
import com.muy.microservice.user.repository.IUserRandomRepository;
import com.muy.microservice.user.repository.IUserRepository;
import com.muy.misc.ModelUtils;
import com.muy.misc.RandomUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanglikai on 2018/3/7.
 */
@Component
@Service(interfaceClass = IUserManageService.class, timeout = 200000)
public class UserManageServiceImpl implements IUserManageService {
  @Resource
  private IUserRepository userRepository;
  @Resource
  private IUserRandomRepository userRandomRepository;

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

  /**
   * 初始化随机数.
   *
   * @return
   */
  @Transactional
  @Override
  public boolean initRandom() {
    /* 随机数生成 */
    Set<Integer> randoms = RandomUtils.generateRandoms();

    List<UserRandomDO> target = new ArrayList<>(randoms.size());
    randoms.forEach(el -> {
      UserRandomDO random = new UserRandomDO();
      random.setRandom(el);

      target.add(random);
    });

    /* 初始化随机数 */
    return userRandomRepository.addBatch(target);
  }
}
