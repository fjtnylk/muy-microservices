package com.muy.web.b2b.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.muy.microservice.user.query.RegisterUserQuery;

/**
 * Created by yanglikai on 2018/3/7.
 */
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class B2BRegisterUserQuery extends RegisterUserQuery {
}
