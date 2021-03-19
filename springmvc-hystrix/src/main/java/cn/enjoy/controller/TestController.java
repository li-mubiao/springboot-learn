package cn.enjoy.controller;

import cn.enjoy.annotation.MappingAndCircuit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname TestController
 * @Description TODO
 * @Author James
 * Date 2020/12/5 15:09
 * Version 1.0
 */
//http://127.0.0.1:9090/test/test2
@Controller
@MappingAndCircuit("/test")
public class TestController {

    @MappingAndCircuit(value = "test1",fallbackMethod = "test1fallback")
    public @ResponseBody
    String test1(String param) {
        if("James".equalsIgnoreCase(param)) throw new RuntimeException("s");
        return "test1";
    }

    @MappingAndCircuit("test2")
    public @ResponseBody String test2() {
        return "test2";
    }

    public String test1fallback(String param) {
        System.out.println("test1fallback");
        return "test1fallback";
    }
}
