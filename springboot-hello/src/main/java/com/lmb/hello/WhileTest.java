package com.lmb.hello;

import lombok.SneakyThrows;
import org.aspectj.util.FileUtil;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2020-11-11 13:50
 */
public class WhileTest {

    public static void main(String[] args) throws Exception {
        String FILE_IN = "E:\\BaiduNetdiskDownload\\24-Java并发编程实战\\123";
        File f = new File(FILE_IN);
        List<String> list = new ArrayList<String>();
        list = getFileList(f);

        System.out.println(list.size());

        for (String l : list) {
            BufferedReader br = new BufferedReader(new FileReader(new File(l)));
            String line = br.readLine();

        }

    }


    public static List<String> getFileList(File file) {

        List<String> result = new ArrayList<String>();

        if (!file.isDirectory()) {

            result.add(file.getAbsolutePath());
        } else {
            File[] directoryList = file.listFiles(new FileFilter() {
                @SneakyThrows
                @Override
                public boolean accept(File file) {
                    if (file.isFile() && file.getName().indexOf("html") > -1) {
                        System.out.println("<a href=\""+file.getAbsolutePath()+"\">"+file.getName()+"</a><br><br>");
                        return true;
                    } else {
                        getFileList(file);
                        return false;
                    }
                }
            });
            for (int i = 0; i < directoryList.length; i++) {
                result.add(directoryList[i].getPath());
            }
        }

        return result;
    }
}