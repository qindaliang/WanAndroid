package com.qin.wanandroid.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by qindl
 * on 2018/10/22
 */
public class DateUtil {
    public static String format(long time){
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static void main(String sd[]){
        System.out.println(format(1539100800000l));
        System.out.println(7/2);
    }
}
