package cn.enjoy.aop;

import cn.enjoy.annotation.MappingAndCircuit;
import cn.enjoy.hystrix.ControllerhystrixCommand;
import com.netflix.hystrix.*;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Classname CircuitBreakerAdvice
 * @Description TODO
 * @Author James
 * Date 2020/12/5 17:36
 * Version 1.0
 */
public class CircuitBreakerAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return hystrixHandler(methodInvocation);
    }

    private Object hystrixHandler(MethodInvocation methodInvocation) throws Exception {
        Class<?> targetClass = findTargetClass(methodInvocation.getThis());
        //找到原始method对象
        Method specificMethod = AopUtils.getMostSpecificMethod(methodInvocation.getMethod(), targetClass);
        //获取方法上的注解实体
        MappingAndCircuit mergedAnnotation = AnnotatedElementUtils.findMergedAnnotation(specificMethod, MappingAndCircuit.class);
        HystrixCommandGroupKey hystrixCommandGroupKey = HystrixCommandGroupKey.Factory.asKey(mergedAnnotation.groupKey());
        
        HystrixCommand.Setter setter = HystrixCommand.Setter.withGroupKey(hystrixCommandGroupKey)
                .andCommandKey(HystrixCommandKey.Factory.asKey(mergedAnnotation.commandKey()))
                //strategy()--线程池隔离策略
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationStrategy(mergedAnnotation.strategy()))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(mergedAnnotation.threadPoolKey()));
        ControllerhystrixCommand controllerhystrixCommand = new ControllerhystrixCommand(setter,methodInvocation);
        //这个就是核心逻辑
        return controllerhystrixCommand.execute();
    }

    public static Class<?> findTargetClass(Object proxy) throws Exception {
        if (AopUtils.isAopProxy(proxy)) {
            AdvisedSupport advised = getAdvisedSupport(proxy);
            if (AopUtils.isJdkDynamicProxy(proxy)) {
                TargetSource targetSource = advised.getTargetSource();
                return targetSource.getTargetClass();
            }
            Object target = advised.getTargetSource().getTarget();
            return findTargetClass(target);
        } else {
            return proxy == null ? null : proxy.getClass();
        }
    }

    public static AdvisedSupport getAdvisedSupport(Object proxy) throws Exception {
        Field h;
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            h = proxy.getClass().getSuperclass().getDeclaredField("h");
        } else {
            h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        }
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(proxy);
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        return (AdvisedSupport) advised.get(dynamicAdvisedInterceptor);
    }
}
