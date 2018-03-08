package com.muy.web.b2b.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.muy.microservice.user.query.LoginUserQuery;

/**
 * Created by yanglikai on 2018/3/8.
 */
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class B2BLoginUserQuery extends LoginUserQuery {
}
