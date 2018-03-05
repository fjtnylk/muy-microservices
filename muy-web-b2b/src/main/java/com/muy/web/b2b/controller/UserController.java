package com.muy.web.b2b.controller;

import com.muy.microservice.user.query.CreateUserQuery;
import com.muy.microservice.user.query.DeleteUserQuery;
import com.muy.microservice.user.query.LoadUserQuery;
import com.muy.microservice.user.query.UpdateUserQuery;
import com.muy.misc.ModelUtils;
import com.muy.plugins.spring.boot.mvc.annotation.RequestURL;
import com.muy.web.b2b.query.B2BCreateUserQuery;
import com.muy.web.b2b.query.B2BDeleteUserQuery;
import com.muy.web.b2b.query.B2BLoadUserQuery;
import com.muy.web.b2b.query.B2BUpdateUserQuery;
import com.muy.web.b2b.service.IUserService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/3/2.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {
  @Resource
  private IUserService userService;

  @PostMapping(value = "/user/v1/create")
  @ResponseBody
  public ApiResult createUser(@RequestBody B2BCreateUserQuery query) {
    CreateUserQuery params = ModelUtils.parse(query, CreateUserQuery.class);

    return ApiResult.success(userService.createUser(params));
  }

  @PostMapping(value = "/user/v1/delete")
  @ResponseBody
  public ApiResult deleteUser(@RequestBody B2BDeleteUserQuery query) {
    DeleteUserQuery params = ModelUtils.parse(query, DeleteUserQuery.class);

    return ApiResult.success(userService.deleteUser(params));
  }

  @PostMapping(value = "/user/v1/update")
  @ResponseBody
  public ApiResult updateUser(@RequestBody B2BUpdateUserQuery query) {
    UpdateUserQuery params = ModelUtils.parse(query, UpdateUserQuery.class);

    return ApiResult.success(userService.updateUser(params));
  }

  @GetMapping(value = "/user/v1/load")
  @ResponseBody
  public ApiResult loadUser(@RequestURL B2BLoadUserQuery query) {
    LoadUserQuery params = ModelUtils.parse(query, LoadUserQuery.class);

    return ApiResult.success(userService.loadUser(params));
  }
}
