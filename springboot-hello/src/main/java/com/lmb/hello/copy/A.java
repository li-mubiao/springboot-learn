package com.lmb.hello.copy;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-05-10 10:04
 */
@Data
public class A {

    private String name;

    private Integer age;

    private List<String> ids;


    public static void main(String[] args) {
        A a3 = new A();
        a3.setName("6.99.0");
        List<A> list = Lists.newArrayList();
        list.add(a3);
        A a1 = new A();
        a1.setName("6.100.0");
        list.add(a1);

        A a2 = list.stream().max(
                (a,b)->{
                    String[] split1 = a.getName().split("\\.");  //以.分隔需要转义
                    String[] split2 = b.getName().split("\\.");
                    int minimumLength=Math.min(split1.length, split2.length);
                    int index = 0;
                    int diff =0;
                    while (index < minimumLength
                            && (diff = Integer.parseInt(split1[index]) - Integer.parseInt(split2[index])) == 0) {
                        index++;
                    }
                    if (diff == 0) {
                        // 如果位数不一致，比较多余位数
                        for (int i = index; i < split1.length; i++) {
                            if (Integer.parseInt(split1[i]) > 0) {
                                return 1;
                            }
                        }
                        for (int i = index; i < split2.length; i++) {
                            if (Integer.parseInt(split2[i]) > 0) {
                                return -1;
                            }
                        }
                        return 0;
                    } else {
                        return diff > 0 ? 1 : -1;
                    }
                }).get();
        System.out.println(a2.getName());
    }
}