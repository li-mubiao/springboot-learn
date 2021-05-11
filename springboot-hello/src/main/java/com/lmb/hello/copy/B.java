package com.lmb.hello.copy;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;
import net.sf.cglib.beans.BeanCopier;

import java.util.List;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-05-10 10:04
 */
@Data
public class B {

    private String name;

    private int age;

    private List<Integer> ids;

    public static void main(String[] args) throws Exception {
//        apacheCopy();
//        springCopy();
        cjLibCopy();

    }

    public static void cjLibCopy() throws Exception {
        A a = new A();
        a.setName("test");
//        a.setAge(1);
        a.setIds(Lists.newArrayList("1", "2", "3"));
        B b  = new B();
        /**
         * 注意第一个参数是源对象，第二个参数是目标对象
         * 类型不匹配的时候拷贝没有报错，获取的时候会报错
         * 包装类型为null时装换为基础类型没有报错
         * Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
         */
        BeanCopier beanCopier = BeanCopier.create(A.class, B.class, false);
        beanCopier.copy(a,b,null);
        System.out.println(a);
        System.out.println(b);
        for (Integer id : b.getIds()) {
            System.out.println(id);
        }
    }

    public static void springCopy() throws Exception {
        A a = new A();
        a.setName("test");
        a.setAge(1);
        a.setIds(Lists.newArrayList("1", "2", "3"));
        B b  = new B();
        /**
         * 注意第一个参数是源对象，第二个参数是目标对象
         * 类型不匹配的时候拷贝没有报错，获取的时候会报错
         * 当包装类为null时装换基础类型会报错
         * Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
         */
        BeanUtils.copyProperties(a,b);
        System.out.println(a);
        System.out.println(b);
//        for (Integer id : b.getIds()) {
//            System.out.println(id);
//        }
    }

    public static void apacheCopy() throws Exception {
        A a = new A();
        a.setName("test");
        a.setIds(Lists.newArrayList("1", "2", "3"));
        B b  = new B();
        /**
         * 注意第一个参数是目标对象，第二个参数是源对象
         * 类型不匹配的时候拷贝没有报错，获取的时候会报错
         * 当包装类为null时装换基础类型会报错
         * Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
         */
        PropertyUtils.copyProperties(b,a);
        System.out.println(a);
        System.out.println(b);
        for (Integer id : b.getIds()) {
            System.out.println(id);
        }
    }
}