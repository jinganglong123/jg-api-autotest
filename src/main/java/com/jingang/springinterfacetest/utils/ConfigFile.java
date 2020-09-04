package com.jingang.springinterfacetest.utils;

import com.jingang.springinterfacetest.config.TestConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.ResourceBundle;

/**
* @program: ConfigFile
* @description: 加载配置文件的工具类
* @author: LiuGang
* @create: 2020/5/13-20:46
**/
@Slf4j
public class ConfigFile {
    public static ResourceBundle bundle = ResourceBundle.getBundle("application-test", Locale.CHINA);

//    public static String getUrl(InterfaceName name){
//        String address = bundle.getString("test.url");
//        String uri = "";
//        //最终测试地址
//        String testUrl;
//
//        if (name == InterfaceName.LOGIN){
//            uri = bundle.getString("login.uri");
//        }
////        if (name == InterfaceName.UPDATEUSERINFO){
////            uri = bundle.getString("updateUserInfo.uri");
////        }
////        if (name == InterfaceName.GETUSERINFO){
////            uri = bundle.getString("getUserInfo.uri");
////        }
////        if (name == InterfaceName.ADDUSER){
////            uri = bundle.getString("addUser.uri");
////        }
//        testUrl = address + uri;
//        System.out.println("获取的接口url：" + testUrl);
//
//        return testUrl;
//    }

    public static void setTestConfig() {
        log.info("==设置TestConfig配置类==开始==");
        try {
            // 样式参考
//            // 处理字符串
//            TestConfig.spacePerformanceId = Integer.valueOf(bundle.getString("spacePerformanceId"));
//            // 处理Integer类型
//            TestConfig.groupIdAuto = Integer.valueOf(bundle.getString("groupIdAuto"));
//            //中文乱码设置参考
//            TestConfig.appName_Prepare = new String(bundle.getString("appName_Prepare").getBytes("ISO-8859-1"), "UTF8");


            // 全局
            // 控制是否发送企业微信通知的开关
//            TestConfig.notificationSwitch = bundle.getString("notificationSwitch");


        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("==设置TestConfig配置类==结束==");
    }

}


