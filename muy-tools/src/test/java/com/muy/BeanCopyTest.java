package com.muy;

import com.muy.misc.ModelUtils;
import java.util.Date;
import org.junit.Test;

/**
 * Created by yanglikai on 2018/3/1.
 */
public class BeanCopyTest {

  @Test
  public void test01() {
    FromBean fromBean = new FromBean();
    fromBean.setUserId(100001L);
    fromBean.setUserName("yanglikai");
    fromBean.setCreateTime(new Date());
    fromBean.setUpdateTime(new Date());

    ToBean toBean = ModelUtils.parse(fromBean, ToBean.class);
    System.out.println(toBean);
  }

  @Test
  public void test02() {
    FromBean fromBean = new FromBean();
    fromBean.setUserId(100001L);
    fromBean.setUserName("yanglikai");
    fromBean.setUpdateTime(new Date());

    ToBean toBean = ModelUtils.parse(fromBean, ToBean.class);
    System.out.println(toBean);
  }
}
