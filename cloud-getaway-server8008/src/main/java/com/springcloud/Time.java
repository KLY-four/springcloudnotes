package com.springcloud;

import java.time.ZonedDateTime;

//断言日期获取
public class Time {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now(); //默认为上海时区
        System.out.println(now);
    }
}
