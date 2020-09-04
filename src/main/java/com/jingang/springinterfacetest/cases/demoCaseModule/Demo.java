package com.jingang.springinterfacetest.cases.demoCaseModule;

import com.jingang.springinterfacetest.cases.TestNGSpringBootCaseConfig;
import com.jingang.springinterfacetest.cases.loginModule.Login;
import com.jingang.springinterfacetest.common.GetTestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import java.net.InetAddress;
import java.util.Map;

/**
 * @program: jg-api-autotest
 * @description: 项目过程中，练习用的，验证某些功能
 * @author: LiuGang
 * @create: 2020-04-16 19:29
 **/
@Slf4j
public class Demo extends TestNGSpringBootCaseConfig {

    //    @Autowired
//    Login login;
//    @Value("${url.ssaUrl}")
//    public String ssaUrl;

    @Autowired
    GetTestData getTestData;


    @Test
    public void test1() {

//        login.caseTrue();
//       Map<String,String> cookies =  getTestData.getLoginCookies();
//       log.info(cookies.toString());
        log.info(System.getProperty("user.dir"));
//        log.info(ssaUrl);
    }

    @Test
    public void testDNS() throws Exception{
        String ip = InetAddress.getByName("www.jd.com").getHostAddress();
        log.info("获取的IP为：" + ip);

    }

    @Test
    public void rndDemo() {
        for (int i = 0; i < 100; i++) {
            int rndNum = (int) (Math.random() * 3);
            log.info(Integer.toString(rndNum));
        }

    }

}
