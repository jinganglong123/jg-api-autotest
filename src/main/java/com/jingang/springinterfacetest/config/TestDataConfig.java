package com.jingang.springinterfacetest.config;

import lombok.Data;
import org.apache.tomcat.util.net.AprSSLSupport;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: jg-api-autotest
 * @description: 测试数据配置的实体类
 * @author: LiuGang
 * @create: 2019-11-15 08:21
 **/
@Component
@ConfigurationProperties(prefix = "data")
@Data
public class TestDataConfig {
    // 登录用户
    public String user;
    public String password;
    // 浏览器的Headers：User-Agent
    public String userAgent;
    // 已经实名+企业机构的有效cookie
    public String cookieOfAuthenticatinoAtCompany;
    // 已经实名+银行机构的有效cookie
    public String cookieOfAuthenticatinoAtBank;
    // 未实名+企业机构的有效cookie
    public String cookieOfNotAuthenticatinoAtCompany;
    // 未实名+银行机构的有效cookie
    public String cookieOfNotAuthenticatinoAtBank;
    // 未实名+未选择机构的有效cookie
    public String cookieOfNotAuthenticatino;


}
