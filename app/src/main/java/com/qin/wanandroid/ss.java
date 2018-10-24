package com.qin.wanandroid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by qindl
 * on 2018/10/24
 */
public class ss {
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    public static void main(String[] args) {
        System.out.println(replaceBlank("just do it!"));
    }
}
