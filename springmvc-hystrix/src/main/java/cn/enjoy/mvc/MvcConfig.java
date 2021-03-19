package cn.enjoy.mvc;

import cn.enjoy.mapping.CircuitBreakerHandlerMethodMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Classname MvcConfig
 * @Description TODO
 * @Author James
 * Date 2020/12/5 15:13
 * Version 1.0
 */
public class MvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new CircuitBreakerHandlerMethodMapping();
    }
}
