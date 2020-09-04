package com.jingang.springinterfacetest.common;

import com.jingang.springinterfacetest.config.TestConfig;
import com.jingang.springinterfacetest.utils.ConfigFile;
import com.jingang.springinterfacetest.utils.Notification;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: jg-api-autotest
 * @description: 发送通知公共类
 * @author: LiuGang
 * @create: 2019-11-18 16:26
 **/
@Slf4j
@Component
@Data
public class SendNotification {
    @Autowired
    protected TestConfig testConfig;

    /**
    * @Description: 发送企业微信消息，info级别
    * @Param: [message, title]
    * @return: void
    * @Author: LiuGang
    * @Date: 2019/11/18
    */
    public void sendInfoOfWeiXin(String message,String title){
        if (testConfig.notificationSwitch.equals("on")){
            Notification.sendToWorkWeiXin(message,title,"info");
        }else{
            log.info("警告：企业微信通知目前处于关闭状态！");
        }
    }
    /**
    * @Description: 发送企业微信消息，warning级别
    * @Param: [message, title]
    * @return: void
    * @Author: LiuGang
    * @Date: 2019/11/18
    */
    public void sendWarningOfWeiXin(String message,String title){
//        ConfigFile.setTestConfig(); //老加载方式，已放弃
        if (testConfig.notificationSwitch.equals("on")){
            Notification.sendToWorkWeiXin(message,title,"warning");
        }else{
            log.info("警告：企业微信通知目前处于关闭状态！");
        }
    }

    /**
    * @Description: 发送企业微信消息，comment级别
    * @Param: [message, title]
    * @return: void
    * @Author: LiuGang
    * @Date: 2019/11/18
    */
   public void sendCommentOfWeiXin(String message,String title){
        if (testConfig.notificationSwitch.equals("on")){
            Notification.sendToWorkWeiXin(message,title,"comment");
        }else{
            log.info("警告：企业微信通知目前处于关闭状态！");
        }
    }


}
