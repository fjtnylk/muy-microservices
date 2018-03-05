package com.muy.web.b2b.query;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.muy.microservice.user.query.LoadUserQuery;

/**
 * Created by yanglikai on 2018/3/2.
 */
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class B2BLoadUserQuery extends LoadUserQuery {
}
