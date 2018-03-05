package com.muy.api.docs.b2b.model.user;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2017/9/6.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户详情返回结果")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDtlVo {
  private String name;
  private String contact;
  private String contactMobile;
}
