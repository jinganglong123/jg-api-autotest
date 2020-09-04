package com.jingang.springinterfacetest.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: jg-api-autotest
 * @description: 通知工具类
 * @author: LiuGang
 * @create: 2019-11-15 18:56
 **/
@Slf4j
public class Notification {
    // 企业微信的webhook地址配置
    static final String webHookUrl = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=cc72ed62-174e-46ea-a3c2-9bbd9dbd2079";
    public static JGHttpResult httpresult;

    /**
     * @Description:发送企业微信通知，其中level可选：info、comment、warning
     * @Param: [message, title, level]
     * @return: void
     * @Author: LiuGang
     * @Date: 2019/11/17
     */
    public static void sendToWorkWeiXin(String message, String title, String level) {

        switch (level) {
            case "info":
                level = "info";
                break;
            case "INFO":
                level = "info";
                break;
            case "warning":
                level = "warning";
                break;
            case "WARNING":
                level = "warning";
                break;
            case "comment":
                level = "comment";
                break;
            case "COMMENT":
                level = "comment";
                break;
            default:
                level = "info";

        }

        String param = String.format("{\n" +
                "    \"msgtype\": \"markdown\",\n" +
                "    \"markdown\": {\n" +
                "        \"content\": \"### <font color=\\\"%s\\\">【%s】</font>\\n" +
                ">%s \\n\"\n" +
                "    }\n" +
                "}\n", level, title, message);

        httpresult = JGHttp.doPostJson(webHookUrl, param);
        if (httpresult.getResponseCode() != 200 && JSONObject.parseObject(httpresult.getResponseBody()).getInteger("errcode") == 0) {
            log.error("发送企业微信失败");
        } else {
            log.info("发送企业微信成功");
        }


    }


}
