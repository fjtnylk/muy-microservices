package com.muy.microservice.user.query;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/1.
 */
@Data
public class UpdateUserQuery implements Serializable {
  private Long userId;
  private String userName;
  private String nickName;
  private String mobile;
  private String birthday;
  private String signature;
  private String sex;
  private String avatar;
}
