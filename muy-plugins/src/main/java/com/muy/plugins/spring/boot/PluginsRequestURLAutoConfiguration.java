package com.muy.plugins.spring.boot;

import com.muy.plugins.spring.boot.annotation.EnablePluginsConfiguration;
import com.muy.plugins.spring.boot.mvc.RequestURLMethodArgumentResolver;
import com.muy.plugins.spring.boot.mvc.annotation.RequestURL;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yanglikai on 2018/3/2.
 */
@Configuration
@ConditionalOnClass(RequestURL.class)
@ConditionalOnBean(annotation = EnablePluginsConfiguration.class)
public class PluginsRequestURLAutoConfiguration extends WebMvcConfigurerAdapter {

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(new RequestURLMethodArgumentResolver());
  }
}
