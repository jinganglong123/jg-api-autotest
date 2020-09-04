package com.jingang.springinterfacetest.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @program: jg-api-autotest
 * @description: 处理字符串的一些常用工具方法
 * @author: LiuGang
 * @create: 2020-05-25 11:37
 **/
@Slf4j
public class JGString {

    /**
     * @Description: 按照字典排序
     * @Param: [strings]
     * @return: java.lang.String[]
     * @Author: 金刚（email：jinganglong123@126.com；WeChat:jinganglong123）
     * @Date: 2020/1/10
     */
    public static String[] sortBySurname(String[] strings) {
        // 1.1 使用匿名内部类根据 surname 排序 players
//        Arrays.sort(strings,new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2){
//                return (s1.compareTo(s2));
//            }
//        });
        // 1.2 使用 lambda 排序，根据 surname
        Arrays.sort(strings, (String s1, String s2) -> s1.compareTo(s2));
        logStrings(strings);
        return strings;
    }

    /**
     * @Description: 按照字符串的长度排序
     * @Param: [strings]
     * @return: java.lang.String[]
     * @Author: 金刚（email：jinganglong123@126.com；WeChat:jinganglong123）
     * @Date: 2020/1/10
     */
    public static String[] sortByLength(String[] strings) {
        Arrays.sort(strings, (String s1, String s2) -> (s1.length() - s2.length()));
        logStrings(strings);
        return strings;
    }

    /**
     * @Description: 检查字符串中是否包含正则子串
     * @Param: [regex, source]
     * @return: boolean
     * @Author: LiuGang(jinganglong123 @ 126.com)
     * @Date: 2019/11/19
     */
    public static boolean matchString(String regex, String source) {
        String pattern = "[\\s\\S]*" + regex + "[\\s\\S]*";
        boolean result = Pattern.matches(pattern, source);

        if (result) {
            log.info("字符串正则匹配成功，源字符串中包含正则子串：" + regex);
        } else {
            log.info("字符串正则匹配失败，正则子串为：" + regex);
        }
        return result;

    }

    /**
     * @Description: 生成包含时间的唯一标志串
     * @Param: []
     * @return: java.lang.String
     * @Author: LiuGang
     * @Date: 2019/3/25
     */
    public static String onlyMark() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd-HHmm-SSS");
        String string = simpleDateFormat.format(new Date());
        int ran = (int) (Math.random() * 100);
        return string + "-" + String.valueOf(ran);

    }
    /**
    * @description: 自定义连接符mark，生成包含时间的唯一标志串
    * @param: [mark]
    * @return: java.lang.String
    * @author: LiuGang
    * @date: 2020/6/17-11:03
    **/
    public static String onlyMark(String mark) {
        if (StringUtils.isEmpty(mark)) {
            mark = "";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd" + mark + "HHmm" + mark + "SSS");
        String string = simpleDateFormat.format(new Date());
        int ran = (int) (Math.random() * 100);
        return string + mark + String.valueOf(ran);

    }


    /**
     * @Description: 打印日志，输出排序好的字符串结果
     * @Param: [strings]
     * @return: void
     * @Author: 金刚（email：jinganglong123@126.com；WeChat:jinganglong123）
     * @Date: 2020/1/10
     */
    private static void logStrings(String[] strings) {
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result += strings[i] + ",";
        }
        log.info("排序结果为：" + result);
    }

    /**
     * @Description: 生成字符串的MD5
     * @Param: [data]
     * @return: java.lang.String
     * @Author: LiuGang
     * @Date: 2020/6/2
     */
    public static String MD5(String data) throws Exception {
        java.security.MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
}
