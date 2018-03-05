package com.muy.microservice.user.query;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/1.
 */
@Data
public class CreateUserQuery implements Serializable {
  private String userName;
  private String nickName;
  private String mobile;
  private String birthday;
  private String signature;
  private String sex;
  private String avatar;
}
