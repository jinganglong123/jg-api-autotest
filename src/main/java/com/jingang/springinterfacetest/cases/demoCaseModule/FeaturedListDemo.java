package com.jingang.springinterfacetest.cases.demoCaseModule;

import com.alibaba.fastjson.JSONObject;
import com.jingang.springinterfacetest.cases.TestNGSpringBootCaseConfig;
import com.jingang.springinterfacetest.utils.JGHttp;
import com.jingang.springinterfacetest.utils.JGHttpResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: jg-api-autotest
 * @description: 获取产品列表接口样例展示
 * @author: LiuGang
 * @create: 2020-08-12 17:45
 **/
@Slf4j
@Component
@Data
public class FeaturedListDemo extends TestNGSpringBootCaseConfig {
//    public JGHttpResult httpresult;
//
//    public boolean caseTrue(String cookie,String type) {
//        Map<String, String> headers = new HashMap<String, String>();
//        // headers.putAll(getTestData.getLoginCookies());
//        // 南京控制台需要使用的header
//        headers.put("Accept", "application/json, text/plain, */*");
//        headers.put("X-Requested-With", "XMLHttpRequest");
//        headers.put("Content-Type", "application/json;charset=UTF-8");
//        headers.put("Cookie", cookie);
//        headers.put("User-Agent", testDataConfig.userAgent);
////      headers.put("Accept", "application/json, text/plain, */*");
//        // get方式
////        Map<String, String> param = new HashMap<String, String>();
////        param.put("", );
////        httpresult = JGHttp.doGet(urlConfig. + urlConfig., param, headers);
//
//        // post方式
//        String param = String.format("{\"type\":\"%s\"}",type);
//        httpresult = JGHttp.doPostJson(urlConfig.apibankUrl + urlConfig.featuredList, param, headers);
//
//        // 通过响应码校验结果
//        if (httpresult.getResponseCode() != 200) {
//            return false;
//        }
//        // 通过响应体中的code码来判断结果
////        if (JSONObject.parseObject(httpresult.getResponseBody()).getInteger("code") != 20000000) {
////            return false;
////        }
//        // 通过响应体中的code码来判断结果--南京控制台
//        if (JSONObject.parseObject(httpresult.getResponseBody()).getInteger("resultCode") != 0) {
//            return false;
//        }
//        // 通过响应体中的message来判断结果
////        if (!JSONObject.parseObject(httpresult.getResponseBody()).getString("message").equals("成功")) {
////            return false;
////        }
//        // 通过响应体中的message来判断结果--南京控制台
////        if (!JSONObject.parseObject(httpresult.getResponseBody()).getString("resultMsg").equals("成功")) {
////            return false;
////        }
//        // 模糊正则匹配关键字来判断结果
////        if(!JGString.matchString("",httpresult.getResponseBody())){
////            return false;
////        }
//
//        // 通过JsonSchema校验接口数据返回格式
////        if (!JGJsonSchemaByFge.AssertJsonSchemaByJsonStringAndJsonFile(httpresult.getResponseBody(),"src/main/resources/jsonSchema/.json"))
////        {
////            return false;
////        }
//        // 通过查询数据库匹配核对检查数据
//
//        // 通过相关接口辅助验证
//
//        return true;
//    }
//
//    /**
//     * 前置步骤：维护本类下所有用例执行前需要准备的前置条件
//     **/
//    @BeforeClass
//    public void beforeClass() {
//        log.info("提示：在该类（com.jingang.springinterfacetest.cases.demoCaseModule.FeaturedListDemo）下所有用例执行前前执行");
//        // 前置条件准备
//
//    }
//
//    /**
//     * 用例维护步骤：基于DDT思路，维护该接口的用例case
//     **/
//    @DataProvider
//    public Object[][] dataT1() {
//        int row = 1;
//        int col = 3;
//        Object[][] objects = new Object[row][col];
//        // 数据处理如下
//        objects[0][0] = "正例：获取产品列表接口基础检查";
//        objects[0][1] = "";
//        objects[0][2] = "PRODUCT";
//        return objects;
//    }
//
//    @Test(dataProvider = "dataT1", priority = 1, groups = {"default"})
//    public void testT(String title,String cookie,String type) {
//        // 打印用例标题
//        log.info(title);
//        // 中间处理
//        // 断言
//        Assert.assertTrue(caseTrue(cookie,type));
//
//    }
//
//    /**
//     * 后置步骤：维护本类下所有用例执行后需要进行的后置处理
//     **/
//    @AfterClass
//    public void afterClass() {
//        log.info("提示：在该类（com.jingang.springinterfacetest.cases.demoCaseModule.FeaturedListDemo）下所有用例执行完毕后执行");
//        // 后置处理
//
//    }


}
