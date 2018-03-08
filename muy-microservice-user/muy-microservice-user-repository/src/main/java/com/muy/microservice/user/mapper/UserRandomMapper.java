package com.muy.microservice.user.mapper;

import com.muy.microservice.user.SuperMapper;
import com.muy.microservice.user.entity.UserRandomDO;
import java.util.Set;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yanglikai on 2018/3/8.
 */
public interface UserRandomMapper extends SuperMapper<UserRandomDO> {

  /**
   * 批量插入.
   *
   * @param randomList
   * @return
   */
  int insertBatch(@Param("randomList") Set<Integer> randomList);

  @Select(value = "select random from my_user_random order by create_time desc limit 1")
  int selectRandom();
}
