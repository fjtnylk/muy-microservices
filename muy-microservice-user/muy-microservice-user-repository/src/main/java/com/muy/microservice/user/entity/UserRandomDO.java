package com.muy.microservice.user.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * Created by yanglikai on 2018/3/8.
 */
@Data
@TableName(value = "my_user_random")
public class UserRandomDO implements Serializable {
  @TableId(value = "random", type = IdType.INPUT)
  private Integer random;
  @TableField(value = "create_time")
  private Date createTime;
  @TableField(value = "update_time")
  private Date updateTime;
}
