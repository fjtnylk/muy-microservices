package com.muy.jobs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.muy.microservice.user.dto.LoginUserDto;
import com.muy.microservice.user.facade.IUserDubboService;
import com.muy.microservice.user.query.LoginUserQuery;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2018/3/13.
 */
@Component
public class StartJob {
  @Reference
  private IUserDubboService userDubboService;

  @Scheduled(cron = "0/10 * * * * *")
  public void soSomething() {
    LoginUserQuery query = new LoginUserQuery();
    query.setUserName("yanglikai");
    query.setPassword("yanglikai");

    LoginUserDto dto = userDubboService.loginAuth(query);
    System.out.println(String.format("userid:{%s}", dto.getUserId()));
  }
}
