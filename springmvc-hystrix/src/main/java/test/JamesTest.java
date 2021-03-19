package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : James
 * @description: TODO
 * @date : 2021/3/18 16:52
 */
public class JamesTest {
    static Map<String, Object> urlHandlerMapping = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("test.JamesController");
        if (clazz.isAnnotationPresent(Controller.class)) {
            RequestMapping erm = clazz.getAnnotation(RequestMapping.class);
            String classPath = erm.value()[0];//  /james

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping er = method.getAnnotation(RequestMapping.class);
                    String methodPath = er.value()[0];//   /query
                    urlHandlerMapping.put(classPath + methodPath, method);
                }
            }
            System.out.println(urlHandlerMapping);
        }
    }
}
