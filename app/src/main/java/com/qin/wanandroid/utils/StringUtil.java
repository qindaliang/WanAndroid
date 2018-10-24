package com.qin.wanandroid.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by qindl
 * on 2018/10/24
 */
public class StringUtil {
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
