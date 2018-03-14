package com.muy.jobs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.muy.microservice.user.dto.LoginUserDto;
import com.muy.microservice.user.facade.IUserDubboService;
import com.muy.microservice.user.query.LoginUserQuery;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/3/13.
 */
@Component
public class UserJob implements SimpleJob {
  @Reference
  private IUserDubboService userDubboService;

  /**
   * 执行作业.
   *
   * @param shardingContext 分片上下文
   */
  //@Scheduled(cron = "0/10 * * * * *")
  @Override
  public void execute(ShardingContext shardingContext) {
    LoginUserQuery query = new LoginUserQuery();
    query.setUserName("yanglikai");
    query.setPassword("yanglikai");

    LoginUserDto dto = userDubboService.loginAuth(query);
    System.out.println(String.format("userid:{%s}", dto.getUserId()));
  }
}
