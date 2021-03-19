package cn.enjoy.hystrixServlet;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class LoadServletImpl implements LoadServlet {
    @Override
    public void loadOnstarp(ServletContext servletContext) {
        ServletRegistration.Dynamic hystrixMetricsStreamServlet
                = servletContext.addServlet("hystrixMetricsStreamServlet", HystrixMetricsStreamServlet.class);
        hystrixMetricsStreamServlet.setLoadOnStartup(1);
        hystrixMetricsStreamServlet.addMapping("/hystrix.stream");

//        ServletRegistration.Dynamic defaults = servletContext.addServlet("default", DefaultServlet.class);
//        defaults.setLoadOnStartup(1);
//        defaults.addMapping("*.css","*.gif","*.jpg","*.js");
    }
}
