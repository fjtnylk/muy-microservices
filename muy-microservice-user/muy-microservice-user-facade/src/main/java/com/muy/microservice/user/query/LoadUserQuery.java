package com.muy.microservice.user.query;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/1.
 */
@Data
public class LoadUserQuery implements Serializable {
  @NotNull
  private Long userId;
}
