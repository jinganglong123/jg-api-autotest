package com.jingang.springinterfacetest.utils;

import lombok.Data;
import org.apache.http.Header;
/**
* @description: 响应结果存储对象
* @author: LiuGang
* @date: 2020/9/5-2:15
**/
@Data
public class JGHttpResult {
    private int responseCode; // 响应码
    private String responseBody; // 响应正文
    private Header[] responseHeaders;  // 响应头信息


    public JGHttpResult() {
        this.responseCode = 0;
        this.responseBody = "";
        this.responseHeaders = null;
    }
    /**
    * @Description: 获取cookies字符串
    * @Param:
    * @return:
    * @Author: LiuGang
    * @Date: 2020/5/12-21:52
    **/
    public String getCookies() {
        String cookies = "";
        for (Header header : responseHeaders) {
            if (header.getName().equals("Set-Cookie")) {
                cookies = cookies + header.getValue() +";";
            }
        }
        return  cookies;

    }


}
