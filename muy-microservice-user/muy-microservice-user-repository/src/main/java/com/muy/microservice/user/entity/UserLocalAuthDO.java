package com.muy.microservice.user.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/7.
 */
@Data
@TableName(value = "my_user_local_auth")
public class UserLocalAuthDO implements Serializable {
  @TableId
  private Long id;
  @TableField(value = "user_name")
  private String userName;
  @TableField(value = "password")
  private String password;
  @TableField(value = "salt")
  private String salt;
  @TableField(value = "create_time")
  private Date createTime;
  @TableField(value = "update_time")
  private Date updateTime;
}
