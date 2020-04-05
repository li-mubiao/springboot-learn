package com.lmb.hello;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2020,
 * FileName: HeapOOM
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/5 11:33
 * Description: 演示堆OOM
 * VM args:-Xms20m -Xmx20m -XX+HeapDumpOnOutOfMemoryError
 * Version:1.0.0
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }

}