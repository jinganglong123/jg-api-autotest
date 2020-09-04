package com.jingang.springinterfacetest.cases.loginModule;

import com.alibaba.fastjson.JSONObject;
import com.jingang.springinterfacetest.cases.TestNGSpringBootCaseConfig;
import com.jingang.springinterfacetest.config.TestConfig;
import com.jingang.springinterfacetest.utils.JGHttp;
import com.jingang.springinterfacetest.utils.JGHttpResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: jg-api-autotest
 * @description: 登录接口用例
 * @author: LiuGang
 * @create: 2020-04-07 00:14
 **/
@Slf4j
@Component
@Data
public class Login extends TestNGSpringBootCaseConfig {
    // 存储接口返回的结果
    public JGHttpResult jgHttpResult;
    //   正例模块模板
//    public boolean caseTrue(String captchaCode,String username,String paaword) {
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Content-Type", "application/x-www-form-urlencoded");
////        String param = String.format("", );
//        Map<String,String> param = new HashMap<>();
//        param.put("fp",captchaCode);
//        param.put("username",username);
//        param.put("password",paaword);
////        jgHttpResult = JGHttp.doPost(urlConfig.ssaUrl + urlConfig.login +"?ReturnUrl=" +urlConfig.apiDesignerUrl+urlConfig.apiDesignerUrlLogin, param, headers);
//        jgHttpResult = JGHttp.doPost(urlConfig.ssaUrl + urlConfig.login , param, headers);
//
//        if (jgHttpResult.getResponseCode() != 200) {
//            return false;
//        }
//        //        if (JSONObject.parseObject(httpresult.getResponseBody()).getInteger("code") != 0){
//        //            return false;
//        //        }
////        if (JSONObject.parseObject(httpresult.getResponseBody()).getBoolean("success") != true) {
////            return false;
////        }
//
//        return true;
//    }
//


}
