package cn.enjoy.aop;

import cn.enjoy.annotation.MappingAndCircuit;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Method;

/**
 * @Classname CircuitBreakerPointcut
 * @Description TODO
 * @Author James
 * Date 2020/12/5 17:30
 * Version 1.0
 */
public class CircuitBreakerPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        //找到原始方法对象
        Method specificMethod = AopUtils.getMostSpecificMethod(method, targetClass);
        if (AnnotatedElementUtils.hasAnnotation(targetClass, MappingAndCircuit.class)
                || AnnotatedElementUtils.hasAnnotation(specificMethod, MappingAndCircuit.class)) {
            return true;
        }
        return false;
    }
}
