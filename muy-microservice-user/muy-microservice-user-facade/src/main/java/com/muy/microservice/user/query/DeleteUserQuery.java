package com.muy.microservice.user.query;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/1.
 */
@Data
public class DeleteUserQuery implements Serializable {
  private Long userId;
}
