package cn.enjoy.mapping;

import cn.enjoy.annotation.MappingAndCircuit;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * @Classname CircuitBreakerHandlerMethodMapping
 * @Description TODO
 * @Author James
 * Date 2020/12/4 22:03
 * Version 1.0
 */
public class CircuitBreakerHandlerMethodMapping extends RequestMappingHandlerMapping {
    @Override
    protected boolean isHandler(Class<?> beanType) {
        return (AnnotatedElementUtils.hasAnnotation(beanType, Controller.class) ||
                AnnotatedElementUtils.hasAnnotation(beanType, MappingAndCircuit.class) ||
                AnnotatedElementUtils.hasAnnotation(beanType, RequestMapping.class));
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMapping requestMapping = AnnotatedElementUtils.findMergedAnnotation(method, RequestMapping.class);
        if(requestMapping != null) {
            return super.getMappingForMethod(method,handlerType);
        }
        //method方法 上的@RequestMapping注解封装成 info 对象
        RequestMappingInfo info = createRequestMappingInfo(method);
        if (info != null) {
            //类   上的@RequestMapping注解也封装成 typeInfo 对象
            RequestMappingInfo typeInfo = createRequestMappingInfo(handlerType);
            if (typeInfo != null) {
                //把方法上面的注解属性结合到类上面的RequestMappingInfo对象中
                info = typeInfo.combine(info);
            }
//            String prefix = super.getPathPrefix(handlerType);
//            if (prefix != null) {
//                info = RequestMappingInfo.paths(prefix).build().combine(info);
//            }
        }
        return info;
    }

    private RequestMappingInfo createRequestMappingInfo(AnnotatedElement element) {
        MappingAndCircuit mappingAndCircuit = AnnotatedElementUtils.findMergedAnnotation(element, MappingAndCircuit.class);
        RequestCondition<?> condition = (element instanceof Class ?
                getCustomTypeCondition((Class<?>) element) : getCustomMethodCondition((Method) element));
        return (mappingAndCircuit != null ? createRequestMappingInfo(mappingAndCircuit, condition) : null);
    }

    private RequestMappingInfo.BuilderConfiguration config = new RequestMappingInfo.BuilderConfiguration();

    protected RequestMappingInfo createRequestMappingInfo(MappingAndCircuit mappingAndCircuit, RequestCondition<?> customCondition) {
        RequestMappingInfo.Builder builder = RequestMappingInfo
                .paths(resolveEmbeddedValuesInPatterns(mappingAndCircuit.path()))
                .methods(mappingAndCircuit.method())
                .params(mappingAndCircuit.params())
                .headers(mappingAndCircuit.headers())
                .consumes(mappingAndCircuit.consumes())
                .produces(mappingAndCircuit.produces())
                .mappingName(mappingAndCircuit.name());
        if (customCondition != null) {
            builder.customCondition(customCondition);
        }
        return builder.options(this.config).build();
    }
}
