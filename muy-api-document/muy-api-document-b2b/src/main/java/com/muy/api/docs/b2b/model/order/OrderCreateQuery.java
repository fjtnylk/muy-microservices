package com.muy.api.docs.b2b.model.order;

import com.muy.api.docs.b2b.domain.CodeName;
import com.muy.api.docs.b2b.domain.OrderDeliveryAddr;
import com.muy.api.docs.b2b.domain.OrderGoods;
import java.util.List;

/**
 * Created by yanglikai on 2018/1/27.
 */
public class OrderCreateQuery {
  private OrderDeliveryAddr deliveryAddr;
  private OrderDeliveryDateQuery deliveryDate;
  private CodeName orderType;
  private String remark;
  private List<OrderGoods> goods;
  private Integer totalCount;
}
