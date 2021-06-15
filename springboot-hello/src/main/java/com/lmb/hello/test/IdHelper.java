package com.lmb.hello.test;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class IdHelper {


    public static void main(String[] args) {


        long num1 = ThreadLocalRandom.current().nextLong(0, 9);

        int num2 = LocalDateTime.now().getYear() % 2020;

        int num3 = getMinutesOfYear();

        long num4 = ThreadLocalRandom.current().nextInt(1000, 9999);

        System.out.println(num4);

        String tm = String.format("%s%d%d%d%d", "TM", num1, num2, num3, num4);
        System.out.println(tm);
        System.out.println(tm.length());
    }

    private static int getMinutesOfYear() {
        LocalDateTime now = LocalDateTime.now();

        int day = now.getDayOfYear();

        int hour = now.getHour();

        int minutes = now.getMinute();

        // 必须减去今天, 否则会多算一天, 后面的 hour 才是今天已经过去的时间
        return (((day - 1) * 24 + hour) - 1) * 60 + minutes;
    }
}