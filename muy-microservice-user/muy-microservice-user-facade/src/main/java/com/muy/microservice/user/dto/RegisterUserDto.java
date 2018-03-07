package com.muy.microservice.user.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/7.
 */
@Data
@AllArgsConstructor
public class RegisterUserDto implements Serializable {
  private Long userId;
}
