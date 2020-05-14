package com.lmb.hello;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2020,
 * FileName: FileTest
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/26 21:01
 * Description: TODO
 * Version:1.0.0
 */
public class FileTest {

        public static List<File> getFiles(String path){
        File root = new File(path);
        List<File> files = new ArrayList<File>();
        if(!root.isDirectory()){
            files.add(root);
        }else{
            File[] subFiles = root.listFiles();
            for(File f : subFiles){
                List<File> files1 = getFiles(f.getAbsolutePath());
                for (File file : files1) {
                    if(file.getName().endsWith(".html")){
                        files.add(file);
                    }
                }
            }
        }
        return files;
    }

    public static void main(String[] args) throws IOException {
        List<File> files=  getFiles("/Users/limubiao/Downloads/24-Java并发编程实战");

        for (File file1 : files) {
            File file = new File("/Users/limubiao/Downloads/并发/"+file1.getName());
            Files.copy(file1.toPath(), file.toPath());

        }
    }

}