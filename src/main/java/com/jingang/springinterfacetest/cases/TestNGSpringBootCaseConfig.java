package com.jingang.springinterfacetest.cases;

import com.alibaba.dcm.DnsCacheManipulator;
import com.jingang.springinterfacetest.common.GetTestData;
import com.jingang.springinterfacetest.config.TestConfig;
import com.jingang.springinterfacetest.config.TestDataConfig;
import com.jingang.springinterfacetest.config.UrlConfig;
import com.jingang.springinterfacetest.model.ApiInfoModelDemo;
import lombok.extern.slf4j.Slf4j;
import org.apache.groovy.json.internal.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

/**
 * @program: jg-api-autotest
 * @description: testNG结合springBoot的基础配置类
 * @author: LiuGang
 * @create: 2019-08-29 20:26
 **/
@SpringBootTest
@Rollback(false)
@Component
@Slf4j
public class TestNGSpringBootCaseConfig extends AbstractTestNGSpringContextTests {
//    @Autowired(required=false)
//    @Qualifier("testConfigTop")
//    @Autowired
//    public  TestConfigTop testConfigTop;

    // 配置实体类加载
    @Autowired
    protected UrlConfig urlConfig;
    @Autowired
    protected TestDataConfig testDataConfig;
    @Autowired
    protected GetTestData getTestData;
    @Autowired
    protected ApiInfoModelDemo apiInfoModelDemo;
    @Autowired
    protected TestConfig testConfig;
    @BeforeClass
    public void beforeSuperClass(){
        log.info("## 进行dns配置操作");
        try {
            if (testConfig.env.equals("test")){
                DnsCacheManipulator.loadDnsCacheConfig();
                log.info("## 加载测试的dns配置");
            }else{
                DnsCacheManipulator.clearDnsCache();  // 清空 JVM DNS Cache
                log.info("## 清空一下JVM的DNS缓存");
            }
        }catch(Exception e){
            e.printStackTrace();
        }



    }


}
