package com.muy.plugins.spring.boot.mvc;

import com.alibaba.fastjson.JSON;
import com.muy.json.JSONUtils;
import com.muy.plugins.spring.boot.mvc.annotation.RequestURL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by yanglikai on 2018/3/2.
 */
public class RequestURLMethodArgumentResolver implements HandlerMethodArgumentResolver {
  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.hasParameterAnnotation(RequestURL.class);
  }

  @Override
  public Object resolveArgument(
      MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
      throws Exception {
    ServletWebRequest request = (ServletWebRequest) webRequest;
    Iterator<String> keys = request.getParameterNames();
    Map<String, String> parameters = new HashMap<>();

    while (keys.hasNext()) {
      String key = keys.next();
      String value = request.getParameter(key);

      parameters.put(key, value);
    }

    String param = JSON.toJSONString(parameters);
    Object result = JSONUtils.toBean(param, parameter.getParameterType());
    return result;
  }
}
