package com.jingang.springinterfacetest.common;


import com.jingang.springinterfacetest.config.TestDataConfig;
import com.jingang.springinterfacetest.config.UrlConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* @program: GetTestData
* @description: 获取通用测试数据的通用模块
* @author: LiuGang
* @create: 2020/5/12-21:57
**/

@Component
@Data
@Slf4j
public class GetTestData {
//    @Autowired
//    public Login login;


    // 配置实体类加载
    @Autowired
    protected UrlConfig urlConfig;
    @Autowired
    protected TestDataConfig testDataConfig;



    /**
     * @Description: 获取默认用户的登录cookie
     * @Param: []
     * @return: java.util.Map<java.lang.String,java.lang.String>
     * @Author: LiuGang
     * @Date: 2020/5/12-21:56
     **/
//    public Map<String,String> getLoginCookies(){
//
//        Map<String,String> headers = new HashMap<>();
////        Login login = new Login();
////        login.caseTrue("",testDataConfig.userAdmin,testDataConfig.password);
////        headers.put("Cookie",login.jgHttpResult.getCookies());
//        String token = principal.getToken();
//        accoutLogin.caseTrue(token,testDataConfig.userAdmin,token,testDataConfig.cookieJsessionid);
//        headers.put("Cookie",accoutLogin.jgHttpResult.getCookies());
//        return  headers;
//
//    }



}
