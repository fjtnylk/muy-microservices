package com.muy.microservice.user.query;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/7.
 */
@Data
public class RegisterUserQuery implements Serializable {
  @NotBlank
  private String userName;
  @NotBlank
  private String password;
}
