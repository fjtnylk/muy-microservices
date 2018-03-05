package com.muy.plugins.spring.boot;

import com.muy.plugins.spring.boot.annotation.EnablePluginsConfiguration;
import com.muy.plugins.spring.boot.validation.ValidationAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yanglikai on 2018/3/5.
 */
@Configuration
@ConditionalOnBean(annotation = EnablePluginsConfiguration.class)
@Import(ValidationAspect.class)
public class PluginsValidationAutoConfiguration {
}
