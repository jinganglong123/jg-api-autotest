package com.jingang.springinterfacetest.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @program: jg-api-autotest
 * @description: 通用的一些工具方法
 * @author: LiuGang
 * @create: 2019-03-11 17:05
 **/
@Slf4j
public class JGGeneralUtil {
    // 获取当前项目的绝对路径，eg: D:\repository-jd-coding-project\jg-api-autotest
    public static String projectPath = System.getProperty("user.dir");

    /**
     * @Description: 让线程强制等待一段时间
     * @Param: [second]
     * @return: void
     * @Author: LiuGang
     * @Date: 2019/5/7
     */
    public static void sleepBySecond(long second) {
        try {
            log.info("强制等待：" + second + "秒");
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
    * @description: 获取随机数，区间[min,max]
    * @param: [min, max]
    * @return: int
    * @author: LiuGang
    * @date: 2020/6/10-10:52
    **/
    public static int getRandNumber(int min,int max){
        return (int)(Math.random()*(max-min+1));
    }




}
