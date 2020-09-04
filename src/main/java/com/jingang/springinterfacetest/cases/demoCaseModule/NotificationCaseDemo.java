package com.jingang.springinterfacetest.cases.demoCaseModule;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @program: jg-api-autotest
 * @description: 消息通知演示demo
 * @author: LiuGang
 * @create: 2019-11-19 16:19
 **/
@Slf4j
public class NotificationCaseDemo {
    @DataProvider
    public Object[][] dataT01() {
        int row = 1;
        int col = 2;
        Object[][] objects = new Object[row][col];

        // 数据处理如下
        objects[0][0] = "正例：发送通知演示demo-失败时候发送企业微信通知";
        objects[0][1] = "abc";


        //    for (int i = 0;i < row;i++){
        //
        //    }

        return objects;
    }

    @Test(dataProvider = "dataT01", priority = 1, groups = {"default"})
    public void testT01(String title, String str) {
        // 打印用例标题
        log.info(title);
        log.info(str);
        //中间处理
        Assert.assertTrue(false);


    }

}
