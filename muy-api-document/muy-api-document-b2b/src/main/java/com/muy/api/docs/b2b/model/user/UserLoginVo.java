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
 * Created by yanglikai on 2017/9/6.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "登录成功返回结果")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserLoginVo {
  @ApiModelProperty(value = "用户名")
  private String userName;
  @ApiModelProperty(value = "登录令牌")
  private String token;
}
