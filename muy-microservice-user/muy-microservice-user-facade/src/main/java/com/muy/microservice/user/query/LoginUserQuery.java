package com.muy.microservice.user.query;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/7.
 */
@Data
public class LoginUserQuery implements Serializable {
  @NotNull
  private String userName;
  @NotNull
  private String password;
}
