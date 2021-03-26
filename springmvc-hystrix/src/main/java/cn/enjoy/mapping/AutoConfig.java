package cn.enjoy.mapping;

import cn.enjoy.mvc.MvcConfig;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Classname AutoConfig
 * @Description TODO
 * @Author James
 * Date 2020/12/5 15:21
 * Version 1.0
 */
@Configuration
@Import({MvcConfig.class, AnnotationAwareAspectJAutoProxyCreator.class})
//@EnableWebMvc
public class AutoConfig {
/*    @Bean
    public HystrixMetricsStreamServlet hystrixMetricsStreamServlet() {
        return new HystrixMetricsStreamServlet();
    }

    @Bean
    public ServletRegistrationBean registration(HystrixMetricsStreamServlet servlet) {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(servlet);
        registrationBean.setEnabled(true);//是否启用该registrationBean
        registrationBean.addUrlMappings("/hystrix.stream");
        return registrationBean;
    }*/
}
