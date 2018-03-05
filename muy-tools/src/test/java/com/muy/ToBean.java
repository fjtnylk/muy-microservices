package com.muy;

import java.util.Date;

/**
 * Created by yanglikai on 2018/3/1.
 */
public class ToBean {
  private Long userId;
  private String userName;
  private Date createTime;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ToBean{");
    sb.append("userId=").append(userId);
    sb.append(", userName='").append(userName).append('\'');
    sb.append(", createTime=").append(createTime);
    sb.append('}');
    return sb.toString();
  }
}
