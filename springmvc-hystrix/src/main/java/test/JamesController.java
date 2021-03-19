package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : James
 * @description: TODO
 * @date : 2021/3/18 16:50
 */
@Controller
@RequestMapping("/james")
public class JamesController {
    @RequestMapping("/query")
    public void query(){
        System.out.println("----query");
    }


    @RequestMapping("/cancel")
    public void cancel(){
        System.out.println("----cancel");
    }


    public void test(){
        System.out.println("----test");
    }
}
