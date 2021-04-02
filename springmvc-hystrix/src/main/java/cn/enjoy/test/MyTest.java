package cn.enjoy.test;

import cn.enjoy.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname MyTest
 * @Description TODO
 * @Author James
 * Date 2020/12/5 15:24
 * Version 1.0
 */
public class MyTest {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("cn.enjoy.service");
        AccountServiceImpl bean = applicationContext.getBean(AccountServiceImpl.class);
        System.out.println(bean);
    }
}
