package com.muy.microservice.user.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/1.
 */
@Data
@TableName(value = "my_user")
public class UserDO implements Serializable {
  @TableId(value = "user_id", type = IdType.INPUT)
  private Long userId;
  @TableField(value = "user_name")
  private String userName;
  @TableField(value = "nick_name")
  private String nickName;
  @TableField(value = "mobile")
  private String mobile;
  @TableField(value = "birthday")
  private String birthday;
  @TableField(value = "signature")
  private String signature;
  @TableField(value = "sex")
  private String sex;
  @TableField(value = "avatar")
  private String avatar;
  @TableField(value = "create_time")
  private Date createTime;
  @TableField(value = "update_time")
  private Date updateTime;
}
