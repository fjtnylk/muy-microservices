package com.muy.api.docs.b2b.model.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by yanglikai on 2018/1/25.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户登录信息")
public class UserLoginQuery {

  @ApiModelProperty(name = "user_name", value = "姓名")
  @NotEmpty
  private String user_name;
  @ApiModelProperty(name = "password", value = "年龄")
  @NotEmpty
  private String password;
}
