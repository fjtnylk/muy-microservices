package com.muy.web.b2b.controller;

import javax.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanglikai on 2018/3/5.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(ValidationException.class)
  @ResponseBody
  public ApiResult handleValidationException(ValidationException e) {
    return ApiResult.faild(e.getMessage());
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseBody
  public ApiResult handleBadRequestException(HttpMessageNotReadableException e) {
    log.error(e.getMessage());
    return ApiResult.faild(500, "请求参数错误");
  }

  @ExceptionHandler(UnsupportedOperationException.class)
  @ResponseBody
  public ApiResult handleUnsuppotedOptException(UnsupportedOperationException e) {
    log.error(e.getMessage());
    return ApiResult.faild(500, "请求参数错误");
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseBody
  public ApiResult handleRuntimeException(RuntimeException e) {
    log.error(e.getMessage());
    return ApiResult.faild(500, "服务器异常.");
  }
}
