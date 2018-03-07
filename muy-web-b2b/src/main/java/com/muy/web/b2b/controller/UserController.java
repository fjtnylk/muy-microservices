package com.muy.web.b2b.controller;

import com.muy.plugins.spring.boot.mvc.annotation.RequestURL;
import com.muy.plugins.spring.boot.validation.annotation.ParameterValid;
import com.muy.web.b2b.query.B2BCreateUserQuery;
import com.muy.web.b2b.query.B2BDeleteUserQuery;
import com.muy.web.b2b.query.B2BLoadUserQuery;
import com.muy.web.b2b.query.B2BRegisterUserQuery;
import com.muy.web.b2b.query.B2BUpdateUserQuery;
import com.muy.web.b2b.service.IUserService;
import javax.annotation.Resource;
import javax.validation.Valid;
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
  @ParameterValid
  @ResponseBody
  public ApiResult createUser(@RequestBody B2BCreateUserQuery query) {
    return ApiResult.success(userService.createUser(query));
  }

  @PostMapping(value = "/user/v1/delete")
  @ParameterValid
  @ResponseBody
  public ApiResult deleteUser(@RequestBody B2BDeleteUserQuery query) {
    return ApiResult.success(userService.deleteUser(query));
  }

  @PostMapping(value = "/user/v1/update")
  @ParameterValid
  @ResponseBody
  public ApiResult updateUser(@RequestBody B2BUpdateUserQuery query) {
    return ApiResult.success(userService.updateUser(query));
  }

  @GetMapping(value = "/user/v1/load")
  @ParameterValid
  @ResponseBody
  public ApiResult loadUser(@RequestURL B2BLoadUserQuery query) {
    return ApiResult.success(userService.loadUser(query));
  }

  @PostMapping(value = "/user/v1/register")
  @ParameterValid
  @ResponseBody
  public ApiResult registerUser(@RequestBody B2BRegisterUserQuery query) {
    return ApiResult.success(userService.register(query));
  }
}
