package com.muy.microservice.user.repository;

import com.baomidou.mybatisplus.service.IService;
import com.muy.microservice.user.entity.UserRandomDO;
import java.util.List;
import java.util.Set;

/**
 * Created by yanglikai on 2018/3/8.
 */
public interface IUserRandomRepository extends IService<UserRandomDO> {

  /**
   * 添加用户随机数.
   *
   * @param target
   * @return
   */
  boolean addTarget(UserRandomDO target);

  /**
   * 批量添加用户随机数.
   *
   * @param batch
   * @return
   */
  boolean addBatch(List<UserRandomDO> batch);

  /**
   * 批量添加用户随机数.
   *
   * @param randomList
   * @return
   */
  boolean addBatch(Set<Integer> randomList);

  /**
   * 删除随机数.
   *
   * @param random
   * @return
   */
  boolean deleteTarget(Integer random);

  /**
   * 查询随机数.
   *
   * @return
   */
  Integer queryRandom();
}
