package com.muy.microservice.user.repository.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.muy.microservice.user.entity.UserRandomDO;
import com.muy.microservice.user.mapper.UserRandomMapper;
import com.muy.microservice.user.repository.IUserRandomRepository;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2018/3/8.
 */
@Repository
public class UserRandomRepository
    extends ServiceImpl<UserRandomMapper, UserRandomDO> implements IUserRandomRepository {
  @Resource
  private UserRandomMapper userRandomMapper;

  /**
   * 添加用户随机数.
   *
   * @param target
   * @return
   */
  @Override
  public boolean addTarget(UserRandomDO target) {
    return super.insert(target);
  }

  /**
   * 批量添加用户随机数.
   *
   * @param batch
   * @return
   */
  @Override
  public boolean addBatch(List<UserRandomDO> batch) {
    return super.insertBatch(batch);
  }

  /**
   * 批量添加用户随机数.
   *
   * @param randomList
   * @return
   */
  @Override
  public boolean addBatch(Set<Integer> randomList) {
    int result = userRandomMapper.insertBatch(randomList);
    return result > 0;
  }

  /**
   * 删除随机数.
   *
   * @param random
   * @return
   */
  @Override
  public boolean deleteTarget(Integer random) {
    return super.deleteById(random);
  }

  /**
   * 查询随机数.
   *
   * @return
   */
  @Override
  public Integer queryRandom() {
    return userRandomMapper.selectRandom();
  }
}
