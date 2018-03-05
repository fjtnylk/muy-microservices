package com.muy.api.docs.b2b.controller.user;

import com.muy.api.docs.b2b.constant.Globals;
import com.muy.api.docs.b2b.controller.ApiResult;
import com.muy.api.docs.b2b.model.user.UserDtlVo;
import com.muy.api.docs.b2b.model.user.UserLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2018/1/27.
 */
@Api(tags = "用户管理", produces = "application/json", consumes = "application/json")
@RestController
public class UserController {

  @ApiOperation(value = "登录", notes = "用户登录接口", response = UserLoginVo.class, responseContainer = "List")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "user_name", value = "登录用户名", required = true, dataType = "string"),
      @ApiImplicitParam(name = "password", value = "登录密码", required = true, dataType = "string")})
  @PostMapping(value = "/api/caisx.b2b/" + Globals.API_VERSION + "/login")
  public void login() {
  }

  @ApiOperation(value = "退出")
  @PostMapping(value = "/api/caisx.b2b/" + Globals.API_VERSION + "/logout")
  public ApiResult logout() {
    return ApiResult.success();
  }

  @ApiOperation(value = "用户详情")
  @GetMapping(value = "/api/caisx.user.dtl/" + Globals.API_VERSION + "/get")
  public UserDtlVo userDtl() {
    //long userId = UserContext.getUserId();
    //UserDtlVo userDtlVo = userService.loadUserDtl(userId);
    UserDtlVo userDtlVo = new UserDtlVo("yanglikai", "杨礼凯", "13671803404");
    return userDtlVo;
  }
}
