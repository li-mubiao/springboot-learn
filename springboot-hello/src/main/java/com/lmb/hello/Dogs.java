package com.lmb.hello;

/**
 * Copyright (C), 2020,
 * FileName: Dogs
 * Author:   mubiao0205@gmail.com
 * Date:     2020/3/29 12:30
 * Description: TODO
 * Version:1.0.0
 */
public class Dogs {
    String name;
    String says;

    public static void main(String[] args) {
        Dogs dogs1 = new Dogs();
        Dogs dogs3 = new Dogs();
        Dogs dogs2 = new Dogs();
        dogs1.name = "spot";
        dogs2.name = "scruffy";
        dogs1.says = "Ruff!";
        dogs2.says = "Wurf!";
        dogs3.name = dogs1.name;
        dogs3.says = dogs1.says;
        System.out.println(dogs1.name == dogs3.name);
        System.out.println(dogs1.name.equals(dogs3.name));
    }

}