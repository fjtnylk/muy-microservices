package com.muy.microservice.user.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/8.
 */
@Data
public class LoginUserDto implements Serializable {
  private Long userId;

  private LoginUserDto() {
    this.userId = 0L;
  }

  public static LoginUserDto empty() {
    return new LoginUserDto();
  }

  public static boolean isEmpty(LoginUserDto target) {
    return target == null || target.getUserId() == 0L;
  }

  public static LoginUserDto creaet() {
    return new LoginUserDto();
  }

  public LoginUserDto withUserId(Long userId) {
    this.userId = userId;
    return this;
  }
}
