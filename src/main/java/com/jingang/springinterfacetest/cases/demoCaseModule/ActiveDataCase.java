package com.jingang.springinterfacetest.cases.demoCaseModule;

import com.jingang.springinterfacetest.cases.TestNGSpringBootCaseConfig;
import com.jingang.springinterfacetest.utils.JGHttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

/**
 * @program: jg-api-autotest
 * @description: 基于动态数据的用例demo，注意要继承 TestNGSpringBootCaseConfig
 * @author: LiuGang
 * @create: 2019-11-15 07:57
 **/
@Slf4j
@Component
public class ActiveDataCase extends TestNGSpringBootCaseConfig {

//  建议将下面的模板加入idea中的 Live Templates
    // 存储接口返回的结果
//    public JGHttpResult httpresult;
    //   正例模块模板
//
//    public boolean caseTrue(, String token) {
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("token", token);
//        String param = String.format("", );
//        httpresult = JGhttp.doPostJson(TestConfig.testUrl +, param, headers);
//        if (httpresult.getResponseCode() != 200) {
//            return false;
//        }
//        //        if (JSONObject.parseObject(httpresult.getResponseBody()).getInteger("code") != 0){
//        //            return false;
//        //        }
//        if (JSONObject.parseObject(httpresult.getResponseBody()).getBoolean("success") != true) {
//            return false;
//        }
//
//        return true;
//    }

    // 基于code码验证的失败用例模块模板

//    public boolean caseFalseCode(Integer errCode, String token) {
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("token", token);
//        String param = String.format("", );
//        httpresult = JGhttp.doPostJson(TestConfig.testUrl +, param, headers);
//
//        if (JSONObject.parseObject(httpresult.getResponseBody()).getInteger("code") != errCode) {
//            return false;
//        }
//
//        return true;
//    }

    // 基于错误信息msg验证的失败用例模块模板

//    public boolean caseFalseMsg(String msgerr, String token) {
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("token", token);
//        String param = String.format("", );
//        httpresult = JGhttp.doPostJson(TestConfig.testUrl +, param, headers);
//
//        if (JSONObject.parseObject(httpresult.getResponseBody()).getInteger("code") != 500) {
//            return false;
//        }
//        if (!JSONObject.parseObject(httpresult.getResponseBody()).getString("msg").equals(msgerr)) {
//            return false;
//        }
//
//        return true;
//    }

//  正例维护模板（主要用于动态数据的case维护）

//    @DataProvider
//    public Object[][] dataT(){
//        int row = 1;
//        int col = 1;
//        Object[][] objects = new Object[row][col];
//        String token = GetTestData.getAdminLoginToken();
//        // 数据处理如下
//        objects[0][0] = "正例：";
//        objects[0][1] = ;
//        objects[0][2] = ;
//        objects[0][3] = ;
//        objects[0][4] = ;
//        objects[0][5] = ;
//        objects[0][6] = ;
//        objects[0][7] = ;
//
//    //    for (int i = 0;i < row;i++){
//    //
//    //    }
//
//        return objects;
//    }
//
//    @Test(dataProvider = "dataT",priority = ,groups = {"default"})
//    public void testT(String title,,String token) {
//        // 打印用例标题
//        log.info(title);
//        //中间处理
//
//        //断言
//        Assert.assertTrue(caseTrue(,token));
//
//
//    }


//    /**
//     * @Description: 配置加载演示
//     * @Param: []
//     * @return: void
//     * @Author: LiuGang
//     * @Date: 2019/11/15
//     */
//    @Test
//    void testDemo() {
//        log.info("获取的配置：" + urlConfig.login);
//        log.info("获取的配置：" + urlConfig.testUrl);
//        log.info("获取的配置：" + testDataConfig.userAdmin);
//
//    }






}
