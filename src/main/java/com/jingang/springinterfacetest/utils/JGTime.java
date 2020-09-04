package com.jingang.springinterfacetest.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @program: jg-api-autotest
 * @description: 时间相关的常用工具类
 * @author: LiuGang
 * @create: 2020-05-25 11:53
 **/
@Slf4j
public class JGTime {
    /**
     * @Description: 设置时间样式，并获取当前时间往前/后推几小时后的时间
     * @Param: [format]
     * @return: java.lang.String
     * @Author: LiuGang
     * @Date: 2019/3/25
     */
    public static String getTimeFormat(String format, int hour){
        if (format == null || format.isEmpty())
        {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,hour);
        String time = simpleDateFormat.format(calendar.getTime());
        log.info("生成的时间为："+time);
        return time;
    }
    /**
     * @Description:设置时间样式，并获取当前时间往前/后推几天后的时间
     * @Param: [format, day]
     * @return: java.lang.String
     * @Author: LiuGang
     * @Date: 2020/5/25-11:31
     **/
    public static String getTimeFormatAsDay(String format,int day){

        if (format == null || format.isEmpty())
        {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,day);
        String time = simpleDateFormat.format(calendar.getTime());
        log.info("生成的时间为:"+time);
        return time;
    }

}
